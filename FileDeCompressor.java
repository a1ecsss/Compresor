import java.util.AbstractMap;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileDeCompressor {
    Huffman<String> huff = new Huffman<>();

    public void DecompresseFile(String filePath){
        String compressedFileString = Lector.readFileToString(filePath);
        setHuffmanTree(compressedFileString.substring(0, compressedFileString.indexOf('\u00FF')));
        StringBuilder binaryString = new StringBuilder();
        for (int i = compressedFileString.indexOf('\u00FF') + 1; i < compressedFileString.length(); i++) {
            binaryString.append(decimalToBinary((int) compressedFileString.charAt(i)));
        }
        StringBuilder deCompressedFileString = new StringBuilder();
        StringBuilder bin = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i++) {
            bin.append(binaryString.charAt(i));
            if (huff.searchByValue(bin.toString()) != null){
                deCompressedFileString.append(huff.searchByValue(bin.toString()));
                bin.setLength(0); 
            }
        }
        System.out.println(deCompressedFileString.toString());
        Lector.saveStringToFile(deCompressedFileString.toString(), "decompressed_"+filePath);
    }

    private String decimalToBinary(int n) {
        StringBuilder binary = new StringBuilder();
        if (n == 0) {
            return "00000000"; // 8 bits para 0
        }
        while (n > 0) {
            binary.insert(0, n % 2);
            n /= 2;
        }
        // Rellenar con ceros a la izquierda hasta completar 8 bits
        while (binary.length() < 8) {
            binary.insert(0, '0');
        }
        return binary.toString();
    }
    
    

    private void setHuffmanTree(String diccionaryString){
        int index = 0;
        char character;
        while (index < diccionaryString.length()){
            character = diccionaryString.charAt(index);
            index++;
            StringBuilder number = new StringBuilder();
            while (index < diccionaryString.length() && Character.isDigit(diccionaryString.charAt(index))){
                number.append(diccionaryString.charAt(index));
                index++;
            }
            if (number.length() > 0) {
                int n = Integer.parseInt(number.toString());
                huff.insert(String.valueOf(character), n);
            }
            
        }
        huff.build();
    }
    
}
