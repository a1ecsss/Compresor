import java.util.ArrayList;

public class Heap<Type> {
    private ArrayList<HeapNode<Type>> heap;

    // Constructor
    Heap() {
        heap = new ArrayList<>();
        heap.add(null);  // Insertamos un null en la posición 0 para no usarla
    }

    //inserta un elemento donde pertence
    public void insert(Type value, int priority) {
        HeapNode<Type> newHeapNode = new HeapNode<>(value, priority);
        heap.add(newHeapNode);
        heapifyUp(heap.size() - 1);
    }

    //remueve el primer elemento del arbol
    public HeapNode<Type> remove() {
        if (heap.size() == 1){
            return null;
        }
        if (heap.size() == 2){
            return heap.remove(heap.size() - 1);
        }
        HeapNode<Type> element = heap.get(1);
        heap.set(1, heap.remove(heap.size() - 1));
        heapifyDown(1);
        return element;
    }

    //ordenamiento hacia arriba
    public void heapifyUp(int index) {
        while ((index != 1) && (heap.get(index).priority < heap.get(index / 2).priority)) {
            Switch(index / 2, index);
            index /= 2;
        }
    }

    //ordenamiento hacia abajo
    public void heapifyDown(int index) {
        int indexLeftChildren = index * 2;
        int indexRightChildren = index * 2 + 1;
        int size = heap.size() - 1;
        while ((indexLeftChildren <= size) || (indexRightChildren <= size)) {
            int switchIndex;
            if(indexLeftChildren > size){
                switchIndex = indexRightChildren;
            }else if(indexRightChildren > size){
                switchIndex = indexLeftChildren;
            }else{
                switchIndex = indexLeftChildren;
                if (heap.get(indexLeftChildren).priority > heap.get(indexRightChildren).priority){
                    switchIndex = indexRightChildren;
                }
            }
            if (heap.get(switchIndex).priority < heap.get(index).priority){
                Switch(index, switchIndex);
                index = switchIndex;
                indexLeftChildren = index * 2;
                indexRightChildren = index * 2 + 1;
            }else{
                break;
            }
        }
    }

    //cambiar nodos
    private void Switch(int index1, int index2){
        HeapNode<Type> temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    //imrpimir cola
    public void printHeap() {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < heap.size(); i++) {
            result.append(heap.get(i).value.toString());
            if (i < heap.size() - 1) {
                result.append(", ");
            }
        }
        System.out.println(result.toString());
    }
    
    //cola ordenada
    public void printSortedHeap() {
        while(heap.size() > 1){
            System.out.println(remove().value);
        }
    }

    //cola vacia o no
    public boolean isEmpty(){
        return this.heap.size() == 1;
    }

    //tamaño de la cola
    public int size(){
        return this.heap.size() - 1;
    }

}