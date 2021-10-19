package ds.stacksNqueues.basic;

public class Queue<V> {
    private int maxSize;
    private V[] array;
    private int frontElement;
    private int lastElement;
    private int currentSize;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.array = (V[]) new Object[maxSize];
        this.frontElement = 0;
        this.lastElement = -1;
        this.currentSize = 0;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public boolean isFull() {
        return this.currentSize == this.maxSize;
    }

    public V top() {
        if(isEmpty())
            return null;
        return array[frontElement];
    }

    public void enqueue(V value) {
        if(isFull())
            return;
        lastElement = (lastElement + 1) % maxSize;
        array[lastElement] = value;
        currentSize++;
    }

    public V dequeue() {
        if(isEmpty())
            return null;
        V temp = array[frontElement];
        frontElement = (frontElement + 1) % maxSize;
        currentSize--;

        return temp;
    }

}
