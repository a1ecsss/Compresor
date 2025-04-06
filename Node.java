public class Node<Type> {
    public Type value;
    public String code;
    public Node<Type> left, right;

    Node(Type value){
        this.value = value;
    }

    @Override
    public String toString() {
        return ((value != null) ? value.toString() : "null");
    }

}
