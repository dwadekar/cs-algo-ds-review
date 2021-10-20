package ds.stacksNqueues.basic;

public class LinkedListQueue<T> {
    private class Node {
        T data;
        Node next;
        public Node(T value) {
            this.data = value;
        }
    }

    private Node front;
    private Node last;
    private int currentSize;

    public LinkedListQueue() {
        front = null;
        last = null;
        currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public T top() {
        if(isEmpty())
            return null;
        return front.data;
    }

    public void enqueue(T value) {
        Node node = new Node(value);
        if(this.last == null) {
            this.front = this.last = node;
            currentSize++;
            return;
        }
        this.last.next = node;
        this.last = node;
        currentSize++;
    }

    public T dequeue() {
        if(isEmpty())
            return null;
        T temp = this.front.data;
        this.front = this.front.next;
        if(this.front == null) {
            this.last = null;
        }
        currentSize--;
        return temp;
    }

    public void display() {
        Node temp = front;
        System.out.print("HEAD -> ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int getSize() {
        return currentSize;
    }

    public Node getFront() {
        return front;
    }

    public T getFrontData() {
        return front.data;
    }

    public Node getLast() {
        return last;
    }

    public T getLastData() {
        return last.data;
    }
}
