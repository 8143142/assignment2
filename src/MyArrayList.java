import java.util.Arrays;

public class MyArrayList<T> implements MyList<T>{
    private static final int INITIAL_CAPACITY = 10;
    private Object[] array;
    private int size;
    /**
     * @ constructor MyArrayList
     * @ there is no parameters
     * @ returns void
     **/
    public MyArrayList() {
        this.array = (T[]) new Object[10];
        this.size = 0;
    }
    /**
     * @ function size
     * @ there is no parameters
     * @ returns int
     * **/
    @Override
    public int size() {
        return size;
    }
    /**
     * @ function contains returns true if object o in the array
     * @ there is no parameters
     * @ returns boolean true or false
     * **/
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++){
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }
    /**
     * @ function add adds object to array
     * @ parameter item is object that will be added
     * @ returns void
     * **/
    @Override
    public void add(T item) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = (T) item;
    }
    /**
     * @ function add gives index to object
     * @ parameter item is object to addition
     * @ parameter index where object will be added
     * @ returns void
     * **/
    @Override
    public void add(Object item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
    }
    /**
     * @ function remove deletes object
     * @ parameter item is deleting object
     * @ returns boolean
     * **/
    // Complexity: 0(n^2)
    @Override
    public boolean remove(Object item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }
    /**
     * @ function remove deletes object
     * @ parameter index is index of deleting object
     * @ returns Object
     * **/
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        T item = (T) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return item;
    }
    /**
     * @ function clear clears array
     * @ there is no parameters
     * @ returns void
     * **/
    @Override
    public void clear() {
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }
    /**
     * @ function get returns object by its index
     * @ parameter index
     * @ returns Object
     * **/
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return (T) array[index];
    }
    /**
     * @ function indexOf returns index
     * @ parameter o for searching
     * @ returns int
     * **/
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * @ function lastIndexOf returns index
     * @ parameter o for searching
     * @ returns int
     * **/
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * @ function sort sorts array (bubble sort, O(n^2))
     * @ there is no parameters
     * @ returns void
     * **/
    @Override
    public void sort() {
        try{
            Integer.valueOf((int) this.get(0));
        } catch (ClassCastException e) {
            return;
        }
        for(int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if ((int) array[j] < (int) array[i]) {
                    T temp = (T) array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
