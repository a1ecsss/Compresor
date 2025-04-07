public class HeapNode<Type> {
    public Type value;
    public int priority;

    public HeapNode(Type value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}
