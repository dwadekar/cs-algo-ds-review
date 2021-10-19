package ds.linkedlist.basic;

public class Main {
    public static void main(String[] args) {
        Integer integer1 = new Integer(1);
        Integer integer2 = new Integer(2);
        Integer integer3 = new Integer(3);
        Integer integer4 = new Integer(4);

        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println(linkedList.isEmpty());

        linkedList.addToFront(integer1);
        linkedList.addToFront(integer2);
        linkedList.addToFront(integer3);
        linkedList.addToFront(integer4);

        System.out.println(linkedList.getSize());

        linkedList.printList();

        linkedList.removeFromFront();
        System.out.println(linkedList.getSize());
        linkedList.printList();

        linkedList.addToLast(new Integer(5));
        System.out.println(linkedList.getSize());
        linkedList.printList();

        System.out.println(linkedList.delete(12));
        System.out.println(linkedList.getSize());
        linkedList.printList();

        System.out.println(linkedList.deleteByIndex(0));
        System.out.println(linkedList.getSize());
        linkedList.printList();

    }
}
