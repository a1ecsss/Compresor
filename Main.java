import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

//"C:\Program Files\Java\jdk-22\bin\java" Main

public class Main {

    public static void main(String[] args) {
        FileCompressor filecompressor = new FileCompressor();
        FileDeCompressor filedecompressor = new FileDeCompressor();
        filecompressor.CompresseFile("archivo.txt");
        filedecompressor.DecompresseFile("compressed_archivo.txt");

    }
}