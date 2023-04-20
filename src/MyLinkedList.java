import java.util.Arrays;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(T item, Node<T> next, Node<T> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    /**
     * @ function size
     * @ Returns the number of elements in this list
     * **/
    @Override
    public int size() {
        return size;
    }
    /**
     * @ Returns true if this list contains the specified element
     * @ param o the element to search for
     * **/
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
    /**
     * @ Adds the specified element to the end of this list
     * @ param item the element to add
     * **/
    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item, null, tail);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }
    /**
     * @ Inserts the specified element at the specified position in this list
     * @ param item  the element to add
     * **/
    @Override
    public void add(T item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(item);
            return;
        }
        Node<T> node = getNode(index);
        Node<T> newNode = new Node<>(item, node, node.prev);
        if (node.prev == null) {
            head = newNode;
        } else {
            node.prev.next = newNode;
        }
        node.prev = newNode;
        size++;
    }

    @Override
    public boolean remove(T item) {
        Node<T> node = head;
        while (node != null) {
            if (node.item.equals(item)) {
                removeNode(node);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = getNode(index);
        removeNode(node);
        return node.item;
    }

    private void removeNode(Node<T> node) {
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next == null) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }
        size--;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).item;
    }

    private Node<T> getNode(int index) {
        if (index < size / 2) {
            Node<T> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<T> node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    @Override
    public int indexOf(Object o) {
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.item.equals(o)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> node = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (node.item.equals(o)) {
                return i;
            }
            node = node.prev;
        }
        return -1;
    }

    @Override
    public void sort() {
        Object[] array = toArray();
        Arrays.sort((T[]) array);
        clear();
        for (Object item : array) {
            add((T) item);
        }
    }

    private Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            array[i] = node.item;
            node = node.next;
        }
        return array;
    }
}