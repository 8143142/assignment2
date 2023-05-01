public class Main {
    public static void main(String[] args) {
        // Creates stack and push some items to it
        MyLinkedListStack<String> stack = new MyLinkedListStack<>();
        stack.push("student1");
        stack.push("student2");

        // Pop items off the stack and print them
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        // Create a queue and enqueue some items onto it
        MyLinkedListQueue<Integer> queue = new MyLinkedListQueue<>();
        queue.enqueue(95);
        queue.enqueue(100);
        queue.enqueue(98);

        // Dequeue items from the queue and print them
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}