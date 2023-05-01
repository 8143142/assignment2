import java.util.EmptyStackException;

public class MyLinkedListStack<T> {
    private MyLinkedList<T> list;

    public MyLinkedListStack() {
        list = new MyLinkedList<T>();
    }

    public void push(T item) {
        list.addFirst(item);
    }

}