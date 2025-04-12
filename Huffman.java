import java.util.HashMap;
import java.util.Map;

public class Huffman<Type> {
    private Heap<Node<Type>> heap;
    private Node<Type> root;
    public HashMap<Type, String> diccionary;
    public HashMap<String, Type> inverseDiccionary;

    Huffman(){
        heap = new Heap<>();
        diccionary = new HashMap<>();
        inverseDiccionary = new HashMap<>();
    }

    //se crea el arbol
    public void build(){
        while (!heap.isEmpty()){
            
            if(heap.size() == 1){
                root = heap.remove().value;
                break;
            }
            HeapNode<Node<Type>> heapNode1 = heap.remove();
            HeapNode<Node<Type>> heapNode2 = heap.remove();
            Node<Type> newNode = new Node<>(null);
            newNode.left = heapNode1.value;
            newNode.right = heapNode2.value;
            heap.insert(newNode, heapNode1.priority + heapNode2.priority);
        }
        buildDiccionaryRecursive(root, "");
    }

    //crear el diccionario recorriendo el arbol 
    private void buildDiccionaryRecursive(Node<Type> node, String code){
        if (node != null){
            if(node.value != null){
                diccionary.put(node.value, code);
                inverseDiccionary.put(code, node.value);
            };
            
            buildDiccionaryRecursive(node.left, code + "0");
            buildDiccionaryRecursive(node.right, code + "1");
        }
    }

    //insertar un valor en la cola de prioridad
    public void insert(Type value, int priority){
        Node<Type> newNodo = new Node<>(value);
        heap.insert(newNodo, priority);
    }

    //imprimir diccionario
    public void printDiccionary(){
        for (Type key : diccionary.keySet()) {
            System.out.println("Clave: " + key + ", Valor: " + diccionary.get(key));
        }
    }

    //Retornar el diccionario en String ( A21B34C9D983 )
    public String getDiccionary(){
        StringBuilder diccionaryString = new StringBuilder();
        for (Type key : diccionary.keySet()) {
            diccionaryString.append(key.toString() + diccionary.get(key).toString());
        }
        return diccionaryString.toString();
    }

    //Busqueda en el diccionario (caracter - codigo binario)
    public String search(Type key) {
        if (diccionary.containsKey(key)) {
            return diccionary.get(key);  //si lo encuentra se devuelve
        }
        return null;  // Si no devuelve null
    }

    //Busqueda en el diccionario inverso (codigo binario - caracter)
    public Type searchInverse(String key) {
        if (inverseDiccionary.containsKey(key)) {
            return inverseDiccionary.get(key);  //si lo encuentra se devuelve
        }
        return null;  // Si no devuelve null
    }
    
}
