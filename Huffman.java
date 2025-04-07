import java.util.HashMap;

public class Huffman<Type> {
    private Heap<Node<Type>> heap;
    private Node<Type> root;
    HashMap<Type, String> diccionary;

    Huffman(){
        heap = new Heap<>();
        diccionary = new HashMap<>();
    }

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

    private void buildDiccionaryRecursive(Node<Type> node, String code){
        if (node != null){
            if(node.value != null){diccionary.put(node.value, code);};
            buildDiccionaryRecursive(node.left, code + "0");
            buildDiccionaryRecursive(node.right, code + "1");
        }
    }

    public void insert(Type value, int priority){
        Node<Type> newNodo = new Node<>(value);
        heap.insert(newNodo, priority);
    }

    public void printDiccionary(){
        for (Type key : diccionary.keySet()) {
            System.out.println("Clave: " + key + ", Valor: " + diccionary.get(key));
        }
    }

    public String getDiccionary(){
        StringBuilder diccionaryString = new StringBuilder();
        for (Type key : diccionary.keySet()) {
            diccionaryString.append(key.toString() + diccionary.get(key).toString());
        }
        return diccionaryString.toString();
    }

    public String search(Type key) {
        // Buscar el elemento en el HashMap
        if (diccionary.containsKey(key)) {
            return diccionary.get(key);  // Si lo encuentra, devuelve el valor
        }
        return null;  // Si no lo encuentra, devuelve null
    }
}
