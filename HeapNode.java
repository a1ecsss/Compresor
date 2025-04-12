public class HeapNode<Type> {
    public Type value;
    public int priority;

    //Constructor
    public HeapNode(Type value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}
