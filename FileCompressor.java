import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileCompressor {
    Huffman<String> huff = new Huffman<>();

    public void CompresseFile(String filePath){
        String fileString = Lector.readFileToString(filePath);
        HashMap<String, Integer> diccionary = Lector.characterCounter(fileString);
        for (String key : diccionary.keySet()) {
            huff.insert(key, diccionary.get(key));
        }
        huff.build();
        StringBuilder binaryString = new StringBuilder();
        StringBuilder compressedFileString = new StringBuilder(HashMapToString(diccionary)+"\u00FF");
        for (int i = 0; i < fileString.length(); i++) {
            binaryString.append(huff.search(String.valueOf(fileString.charAt(i))));
        }
        while (binaryString.length() % 8 != 0) {
            binaryString.append("0");
        }
        for (int i = 0; i < binaryString.length(); i += 8){
            compressedFileString.append((char) binaryToDecimal(binaryString.substring(i, i+8)));
        }
        Lector.saveStringToFile(compressedFileString.toString(), "compressed_"+filePath);
    }

    public int binaryToDecimal(String bin) {
        int result = 0;
        for (int i = 0; i < bin.length(); i++) {
            int bit = Character.getNumericValue(bin.charAt(bin.length() - 1 - i)); //se recorre de izquierda a derecha
            result += bit * Math.pow(2, i);
        }
        return result;
    }

    private String HashMapToString(HashMap<String, Integer> diccionary){
        StringBuilder diccionaryString = new StringBuilder();
        for (String key : diccionary.keySet()) {
            diccionaryString.append(key.toString() + diccionary.get(key).toString());
        }
        return diccionaryString.toString();
    }
    
}
