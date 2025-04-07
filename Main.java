import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

//"C:\Program Files\Java\jdk-22\bin\java" Main

public class Main {

    public static void main(String[] args) {
        FileCompressor filecompressor = new FileCompressor();
        FileDeCompressor filedecompressor = new FileDeCompressor();
        //Scanner scanner = new Scanner(System.in);
        //System.out.print("Ingrese el nombre del archivo: ");
        //String filePath = scanner.nextLine();
        filecompressor.CompresseFile("archivo.txt");
        filedecompressor.DecompresseFile("compressed_archivo.txt");
        //scanner.close();
        
    }
}