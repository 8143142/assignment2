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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++){
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T item) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = item;
    }

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

    @Override
    public void clear() {
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return (T) array[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort() {
        Arrays.sort((T[]) array, 0, size);
    }
}
