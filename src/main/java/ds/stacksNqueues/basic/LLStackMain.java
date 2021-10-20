package ds.stacksNqueues.basic;

public class LLStackMain {
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(20);
        stack.push(30);
        stack.push(50);
        stack.push(80);
        stack.push(40);
        stack.push(60);
        stack.push(75);
        stack.display();
        System.out.println("Stack size: " + stack.getSize());
        System.out.println("Elements removed: " + stack.pop());
        System.out.println("Elements removed: " + stack.pop());
        System.out.println("Stack size: " + stack.getSize());
        stack.display();
    }
}
