package ds.stacksNqueues.basic;

public class Stack<T> {
    private int maxSize;
    private int top;
    private T[] array;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        array = (T[]) new Object[maxSize];
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public T top() {
        if(isEmpty()) {
            return null;
        }
        return array[top];
    }

    public void push(T value) {
        if(isFull()) {
            return;
        }
        array[++top] = value;
    }

    public T pop() {
        if(isEmpty())
            return null;
        return array[top--];
    }
}
