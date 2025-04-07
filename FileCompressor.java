import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileCompressor {
    Huffman<String> huff = new Huffman<>();

    public void textCompressedFile(String filePath){
        String fileString = Lector.readFileToString(filePath);
        HashMap<String, Integer> diccionary = Lector.characterCounter(fileString);
        for (String key : diccionary.keySet()) {
            huff.insert(key, diccionary.get(key));
        }
        huff.build();
        StringBuilder binaryResult = new StringBuilder();
        StringBuilder compressedFileString = new StringBuilder(HashMapToString(diccionary)+"\u00FF");
        for (int i = 0; i < fileString.length(); i++) {
            binaryResult.append(huff.search(String.valueOf(fileString.charAt(i))));
            
            if (binaryResult.length() > 7){
                int asciiCode = binaryToDecimal(binaryResult.substring(0, 8));
                binaryResult.delete(0, 8);
                compressedFileString.append((char) asciiCode);
            }
            //System.out.println("compressedFileString: "+compressedFileString);
        }
        if (binaryResult.length() != 0 ){
            while (binaryResult.length() < 8) {
                binaryResult.append("0");
            }
            int asciiCode = binaryToDecimal(binaryResult.substring(0, 8));
            binaryResult.delete(0, 8);
            compressedFileString.append((char) asciiCode);
        }
        Lector.saveStringToFile(compressedFileString.toString(), "compressed_"+filePath);
    }

    private int binaryToDecimal(String bin) {
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
