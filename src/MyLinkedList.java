public class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T element;
        Node next;
        Node prev;

        public Node(T element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
}