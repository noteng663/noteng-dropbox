/*
* Name: Noah Teng
* Sources: Oracle, w3Books, 
*/

//uhhhhhhh what class do I make{
public class MyArrayList<E> {
    /*
     * Instance Variables:
     * Object[] data:
     * int size:
     */
    Object[] data;
    int size = 0;
    private static final int DEFAULT_CAP_SIZE_VAL = 5;

    @SuppressWarnings("unchecked")
    public E someMethod() {
        return (E) data[0];
    }

    /*
     * Constructor 1
     */
    public MyArrayList() {
        size = DEFAULT_CAP_SIZE_VAL;
        this.data = new Object[size];
    }

    /*
     * Constructor 2
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Invalid capacity");
        }
        this.data = new Object[initialCapacity];
    }

    /*
     * Constructor 3
     */
    public MyArrayList(E[] arr) {
        if (arr == null) {
            size = DEFAULT_CAP_SIZE_VAL;
            this.data = new Object[size];
            return; // fall back
        }
        size = arr.length;
        data = new Object[size]; // updated
        for (int i = 0; i < data.length; i++) {
            data[i] = arr[i];
        }
    }

    public void expandCapacity(int requiredCapacity) {
        int capacity = data.length;
        if (requiredCapacity < capacity) {
            throw new IllegalArgumentException("additional capacity less than current");
        }
        if (capacity > 0) {
            capacity *= 2;
            if (capacity < requiredCapacity) {
                capacity = requiredCapacity;
            }
        } else if (capacity == 0) {
            capacity = DEFAULT_CAP_SIZE_VAL;
        }
        // 58-65 >> int cap = Math.max(data.;emgth == 0 ? DEFAULT_CAP_SIZE_VAL
        // : data.length * 2, len);
        // >>> ? = "<condition>?<result1? : <result2>"
        // before ? marks if statement, if TRUE = result1, ELSE = result2
        Object[] arr = new Object[capacity];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = data[i];
        }
        data = arr;
    }

    public int getCapacity() {
        return data.length;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("can't add");
        }
        if (size == this.getCapacity()) { // THIS.___ means
                                          // "static" applied to class when it isn't ABOUT a specific variable but a
                                          // class
            this.expandCapacity(size += 1); // data is being copied here
        }
        for (int i = size; i > index; i--) { // data is copied a SECOND time
            data[i] = data[i - 1];
        }
        size += 1;
        data[index] = element;
    }

    public void append(E element) {
        if (size == this.getCapacity()) {
            this.expandCapacity(size += 1);
        }
        data[size++] = element; // ++size = NEW size update, size++ = OLD size update
                                // if you print size RN, you get the result of adding to size (size was already
                                // updated)
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("get failed");
        }
        return (E) data[index];
    }

    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("set failed");
        }
        Object removed = data[index]; // can't create generic in java
        data[index] = (E) element;// data is ELEMENT, this. is for METHOD
        return (E) removed;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("set failed");
        }
        Object removed = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return (E) removed;
    }

    public int size() {
        return size; // something to access without accessing rest of data (normal cases)
    }

}