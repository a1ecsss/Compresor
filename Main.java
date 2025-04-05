import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//"C:\Program Files\Java\jdk-22\bin\java" Main

public class Main {
    public static void main(String[] args) {
        Heap<String> heap = new Heap<>();

        HashMap<Character, Integer> letterPriorityMap = new HashMap<>();

        Random random = new Random();

        // Insertar 7 letras aleatorias con prioridades basadas en el alfabeto
        for (int i = 0; i < 7; i++) {
            // Generar una letra aleatoria entre 'A' y 'Z'
            char randomLetter = (char) ('A' + random.nextInt(26));  // Letras de A a Z
            int priority = randomLetter - 'A' + 1;  // Asignar prioridad según la posición en el alfabeto

            // Insertar en el heap
            heap.insert(new DataHolder<>(String.valueOf(randomLetter), priority));
        }
        

        // Imprimir el estado del heap después de las inserciones
        System.out.println("Estado del heap después de las inserciones:");
        heap.printHeap();
        System.out.println("Heap Ordenado:");
        heap.printSortedHeap();
    }
}
