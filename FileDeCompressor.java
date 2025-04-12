import java.util.AbstractMap;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileDeCompressor {
    Huffman<String> huff = new Huffman<>();

    public void DecompresseFile(String filePath){
        String compressedFileString = Lector.readFileToString(filePath);
        int startIndex = compressedFileString.indexOf('\u00FF');
        setHuffmanTree(compressedFileString.substring(0, startIndex));
        StringBuilder binaryString = new StringBuilder();
        for (int i =  startIndex + 1; i < compressedFileString.length(); i++) {
            binaryString.append(decimalToBinary((int) compressedFileString.charAt(i)));
        }
        StringBuilder deCompressedFileString = new StringBuilder();
        StringBuilder bin = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i++) {
            bin.append(binaryString.charAt(i));
            String value = huff.searchInverse(bin.toString());
            if (value != null) {  
                deCompressedFileString.append(value);
                bin.setLength(0);  // Limpiar el StringBuilder
            }
        }
        Lector.saveStringToFile(deCompressedFileString.toString(), "decompressed_"+filePath);
    }

    public String decimalToBinary(int n) {
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.insert(0, n % 2);
            n /= 2;
        }
        //rellenar con ceros a la izquierda hasta completar 8 bits
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
