package ds.linkedlist.basic;

public class LinkedList<T> {
    private Node<T> head;
    private int size;
    private Node<T> tail;

    public void addToFront(T data) {
        Node node = new Node(data);
        node.setNext(head);
        head = node;
        size++;
        if(tail == null) {
            tail = node;
        }
    }

    public void printList() {
        Node current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public Node<T> removeFromFront() {
        if(isEmpty()) {
            tail = null;
            return null;
        }
        Node<T> removeNode = head;
        head = head.getNext();
        removeNode.setNext(null);
        size--;
        return removeNode;
    }

    public void addToLast(T data) {
        Node<T> newNode = new Node<>(data);
        if(this.head == null) {
            head = newNode;
            tail = head;
            return;
        }
        tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    public int indexOf(T data) {
        Node<T> current = this.head;
        int index = 0;

        while (current != null) {
            if(current.getData().equals(data)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public Node<T> getNode(int index) {
        if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index not available: " + index);
        }

        if(index == 0) {
            return this.head;
        }
        if(index == this.size - 1) {
            return this.tail;
        }
        int pointer = 0;
        Node<T> current = this.head;
        while (current != null) {
            if(pointer == index)
                return current;
            current = current.getNext();
            pointer++;
        }
        return null;
    }

    public boolean deleteByIndex(int index) {
        if(this.head == null)
            return false;
        if(index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("Index not available: " + index);
        if(index == 0) {
            head = head.getNext();
            size--;
            return true;
        }
        if(index == size - 1) {
            getNode(index - 1).setNext(null);
            size--;
            return true;
        }
        Node<T> leftNodeFromIndex = getNode(index - 1);
        Node<T> rightNodeFromIndex = getNode(index + 1);
        leftNodeFromIndex.setNext(rightNodeFromIndex);
        size--;
        return true;
    }

    public boolean delete(T data) {
        if(this.head == null)
            return false;
        Node<T> current = this.head;
        if(current.getData().equals(data)) {
            head = head.getNext();
            size--;
            return true;
        }
        int index = indexOf(data);
        if(index > 0) {
            return deleteByIndex(index);
        }
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }
}
