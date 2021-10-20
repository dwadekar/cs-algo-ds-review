package ds.stacksNqueues.basic;

public class LLQueueMain {
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue();
        queue.dequeue();
        queue.display();
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.dequeue();
        queue.display();
        System.out.println("Front Node: " + queue.getFrontData());
        System.out.println("Rear Node: " + queue.getLastData());
        System.out.println("Queue size: " + queue.getSize());
    }
}
