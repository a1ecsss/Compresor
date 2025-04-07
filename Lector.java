import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Lector {

    //Conteo en porcentaje de caracter 
    public static HashMap<String, Integer> characterCounter(String text) {
        HashMap<String, Integer> diccionary = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            String key = String.valueOf(character);
            diccionary.put(key, diccionary.getOrDefault(key, 0) + 1);
        }
        return diccionary;
    }

    public static String readFileToString(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n"); 
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("El nombre del archivo no es válido");
        }
        return content.toString(); 
    }

    public static void saveStringToFile(String text, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(text);  // Escribe el contenido del String en el archivo
        } catch (IOException e) {
            e.printStackTrace();  // Manejo de excepciones si hay problemas al escribir el archivo
        }
    }
    
}
