import java.util.NoSuchElementException;

public class MyLinkedListQueue<E> {
    private MyLinkedList<E> queue;
    /*
    MyLinkedListQueue - constructor
     */
    public MyLinkedListQueue(){
        queue = new MyLinkedList<E>();
    }
    /*
    enqueue - adds  element at the end of the queue
     */
    public void enqueue(E element) {
        queue.add(element);
    }
    /*
    dequeue - removes and returns front element of the queue
     */
    public E dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return queue.remove(0);
    }
    /*
    peek - returns the first elements of the queue
     */
    public E peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return queue.get(0);
    }
    /*
    isEmpty - checking empty or not
     */
    public int size(){
        return queue.size();
    }
    /*
    size - to get the size of the queue
     */
    public boolean isEmpty(){
        return queue.isEmpty();
    }
}