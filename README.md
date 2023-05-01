# assignment2 documentation <img src="https://github.com/blackcater/blackcater/raw/main/images/Hi.gif" height="32"/></h1>
Here is full explanation of functions 
--------    ---------    --------
<b><p>MyArrayList<p></b>
<b>Size</b><br>
<b>Description:</b> *Returns the number of elements in this list*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
 /**
     * @ function size
     * @ Returns the number of elements in this list
     * **/
    @Override
    public int size() {
        return size;
    }
```
--------    ---------    --------
<b>Contains</b><br>
<b>Description:</b> *Returns true if this list contains the specified element*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
 /**
     * @ Returns true if this list contains the specified element
     * @ param o the element to search for
     * **/
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
```
--------    ---------    --------
<b>Add</b><br>
<b>Description:</b> *Adds the specified element to the end of this list*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
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
```
--------    ---------    --------
<b>remove</b><br>
<b>Description:</b> *Removes the element at the specified position in this list*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
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
```
--------    ---------    --------
<b>clear</b><br>
<b>Description:</b> *Removes all of the elements from this list*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
/**
         * @ Removes all of the elements from this list
         * **/
@Override
public void clear() {
        Arrays.fill(elements, null);
        size = 0;
```
--------    ---------    --------
<b>get</b><br>
<b>Description:</b> *Returns the element at the specified position in this list*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
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
```
--------    ---------    --------
<b><p>MyLinkedList<p></b>
<b>Size</b><br>
<b>Description:</b> *Returns the number of elements in this list*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
 /**
     * @ function size
     * @ Returns the number of elements in this list
     * **/
    @Override
    public int size() {
        return size;
    }
```
--------    ---------    --------
<b>Contains</b><br>
<b>Description:</b> *Returns true if this list contains the specified element*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
 /**
     * @ Returns true if this list contains the specified element
     * @ param o the element to search for
     * **/
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
```
--------    ---------    --------
<b>Add</b><br>
<b>Description:</b> *Adds the specified element to the end of this list*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
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
```
--------    ---------    --------
<b>remove</b><br>
<b>Description:</b> *Removes the element at the specified position in this list*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
/**
         * @ Removes element from this list, if it is present
         * @ return true if this list contained the specified element
         * **/
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
```
--------    ---------    --------
<b>clear</b><br>
<b>Description:</b> *Removes all of the elements from this list*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
/**
         * @ Removes all of the elements from this list
         * **/
@Override
public void clear() {
        Arrays.fill(elements, null);
        size = 0;
```
--------    ---------    --------
<b>get</b><br>
<b>Description:</b> *Returns the element at the specified position in this list*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
  /**
         * @ Returns the element at the specified position in this list
         * @ param index the index of the element to return
         * @ return the element at the specified position in this list
         * **/
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
```
