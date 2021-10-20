package ds.stacksNqueues.basic;

public class LinkedListStack<T> {
    private class Node {
        T data;
        Node next;
    }

    private Node top;
    private int size;

    public LinkedListStack() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public T top() {
        if(isEmpty())
            return null;
        return top.data;
    }

    public void push(T value) {
        Node node = new Node();
        if(node == null) {
            return;
        }
        node.data = value;
        node.next = top;
        top = node;
        size++;
    }

    public T pop() {
        if(isEmpty())
            return null;
        T temp = top.data;
        top = top.next;
        size--;

        return temp;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        Node temp = top;
        System.out.print("HEAD -> ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
