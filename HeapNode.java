public class HeapNode<Type> {
    public Type value;
    public double priority;

    public HeapNode(Type value, double priority) {
        this.value = value;
        this.priority = priority;
    }
}
