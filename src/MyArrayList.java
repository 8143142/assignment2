import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
private Object[] elements;
private int size;

public MyArrayList() {
        elements = new Object[10];
        size = 0;
        }

@Override
public int size() {
        return size;
        }
        /**
         * @ Returns true if this list contains the specified element
         * @ param o the element to search for
         * @ return true if this list contains the specified element
         * **/
@Override
public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
        if (elements[i].equals(o)) {
        return true;
        }
        }
        return false;
        }
        /**
         * @ Adds the specified element to the end of this list
         * @ param item the element to add
         * **/
@Override
public void add(T item) {
        if (size == elements.length) {
        elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size++] = item;
        }
        /**
         * @ param item  the element to add
         * @ throws IndexOutOfBoundsException if the index is out of range
         * **/
        @Override
public void add(T item, int index) {
        if (index < 0 || index > size) {
        throw new IndexOutOfBoundsException();
        }
        if (size == elements.length) {
        elements = Arrays.copyOf(elements, elements.length * 2);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
        }
        /**
         * @ Removes element from this list, if it is present
         * @ return true if this list contained the specified element
         * **/
@Override
public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
        if(elements[i].equals(item)) {
        System.arraycopy(elements, i + 1, elements, i, size - i - 1);
        elements[--size] = null;
        return true;
        }
        }
        return false;
        }
        /**
         * @ Removes the element at the specified position in this list
         * @ throws IndexOutOfBoundsException if the index is out of range
         * **/
@Override
public T remove(int index) {
        if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException();
        }
        T item = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return item;
        }
        /**
         * @ Removes all of the elements from this list
         * **/
@Override
public void clear() {
        Arrays.fill(elements, null);
        size = 0;
        }
        /**
         * @ Returns the element at the specified position in this list
         * @ param index the index of the element to return
         * @ return the element at the specified position in this list
         * **/
@Override
public T get(int index) {
        if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
        }
@Override
public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
        if (elements[i].equals(o)) {
        return i;
        }
        }
        return -1;
        }
@Override
public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
        if (elements[i].equals(o)) {
        return i;
        }
        }
        return -1;
        }
@Override
public void sort() {
        Arrays.sort((T[]) elements, 0, size);
        }
        public void addAll(T[] array){
                for(int i = 0; i<array.length; i++)
                        add(array[i]);
        }
}
