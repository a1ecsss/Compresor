public class DataHolder<Type> {
    public Type value;
    public int priority;

    DataHolder(Type value, int priority){
        this.value = value;
        this.priority = priority;
    }
}
