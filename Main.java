import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//"C:\Program Files\Java\jdk-22\bin\java" Main

public class Main {

    public static void main(String[] args) {
        Huffman<String> huff = new Huffman<>();
        huff.insert("C", 1.0);
        huff.insert("D", 1.0);
        huff.insert("!", 1.0);
        huff.insert("B", 2.0);
        huff.insert("R", 2.0);
        huff.insert("A", 5.0); 
        huff.build();
        huff.printDiccionary();
    }
}