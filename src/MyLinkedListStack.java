import java.util.EmptyStackException;
public class MyLinkedListStack<T> {
/*
MyLinkedListStack - constructor
 */
    private MyLinkedList<T> stack;
    public MyLinkedListStack() {
        stack = new MyLinkedList<>();
    }
/*
push - adds element at the top
 */
    public void push(T element) {
        stack.add(element);
    }
/*
pop - removes and returns top element
 */
    public T pop(){
        if (isEmpty())  {
            throw new EmptyStackException();
        }
        return stack.remove(0);
    }
/*
peek - returns first elements
 */
    public T peek(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(0);
    }
/*
isEmpty - checking empty or not
 */
    public boolean isEmpty(){
        return stack.isEmpty();
    }
/*
size - to get the size of the stack
 */
    public int size(){
        return stack.size();
    }

}