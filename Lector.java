import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Lector {

    //Conteo en porcentaje de caracter 
    public static HashMap<String, Integer> characterCounter(String text) {
        HashMap<String, Integer> diccionary = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            String key = String.valueOf(character);
            diccionary.put(key, diccionary.getOrDefault(key, 0) + 1); //crea el diccionario en base a un string
        }
        return diccionary;
    }

    public static String readFileToString(String filePath) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            return new String(bytes, StandardCharsets.UTF_8); //pasa el archivo a un string
        } catch (IOException e) {
            throw new IllegalArgumentException("El nombre del archivo no es válido"); //si hay problemas al leer el archivo
        }
    }
    

    public static void saveStringToFile(String text, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(text);  //escribe el contenido del String en el archivo
        } catch (IOException e) {
            throw new IllegalArgumentException("No se pudo crear el archivo");  //si hay problemas al escribir el archivo
        }
    }
    
}
