import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

//"C:\Program Files\Java\jdk-22\bin\java" Main

public class Main {

    public static void main(String[] args) {
        FileCompressor filecompressor = new FileCompressor();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Ingrese el nombre del archivo: ");
            String filePath = scanner.nextLine();
            filecompressor.textCompressedFile(filePath);
            scanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}