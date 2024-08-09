package dsa.list;

/**
 * Implementation of a dynamic array list.
 *
 * @param <E> the type of elements in this list
 */
public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int size;

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.array = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param capacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified capacity is negative
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        this.array = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Adds a new element with the specified value at the end of the list.
     *
     * @param key the value to be added to the list
     */
    @Override
    public void add(E key) {
        if (this.size == this.array.length) {
            enlarge();
        }
        this.array[this.size] = key;
        this.size++;
    }

    /**
     * Adds a new element with the specified value at the given index.
     * Index starts from 0.
     *
     * @param key   the value to be added
     * @param index the index at which the new element is to be added
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(E key, int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (this.size == this.array.length) {
            enlarge();
        }
        System.arraycopy(this.array, index, this.array, index + 1, this.size - index);
        this.array[index] = key;
        this.size++;
    }

    /**
     * Adds a new element with the specified value at the beginning of the list.
     *
     * @param key the value to be added
     */
    @Override
    public void addFirst(E key) {
        add(key, 0);
    }

    /**
     * Adds a new element with the specified value at the end of the list.
     *
     * @param key the value to be added
     */
    @Override
    public void addLast(E key) {
        add(key);
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param key the value to search for
     * @return true if the list contains the specified element, false otherwise
     */
    @Override
    public boolean contains(E key) {
        for (int index = 0; index < this.size; index++) {
            if (this.array[index].equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the value of the element at the specified index.
     * Index starts from 0.
     *
     * @param index the index of the element whose value is to be returned
     * @return the value of the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E get(int index) {
        checkEmpty();
        checkBoundaries(index);
        return this.array[index];
    }

    /**
     * Returns the value of the first element in the list.
     *
     * @return the value of the first element in the list
     */
    @Override
    public E getFirst() {
        checkEmpty();
        return this.array[0];
    }

    /**
     * Returns the value of the last element in the list.
     *
     * @return the value of the last element in the list
     */
    @Override
    public E getLast() {
        checkEmpty();
        return this.array[this.size - 1];
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param key   the element to be stored at the specified position
     * @param index the index of the element to replace
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public void set(E key, int index) {
        checkBoundaries(index);
        this.array[index] = key;
    }

    /**
     * Removes the element at the specified index.
     * Index starts from 0.
     *
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void remove(int index) {
        checkEmpty();
        checkBoundaries(index);
        System.arraycopy(this.array, index + 1, this.array, index, this.size - index - 1);
        this.size--;
        this.array[this.size] = null;
    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the first element of the list
     */
    @Override
    public E removeFirst() {
        checkEmpty();
        E value = this.array[0];
        remove(0);
        return value;
    }

    /**
     * Removes and returns the last element of the list.
     *
     * @return the last element of the list
     */
    @Override
    public E removeLast() {
        checkEmpty();
        E value = this.array[this.size - 1];
        remove(this.size - 1);
        return value;
    }

    /**
     * Removes all elements from the list.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        this.array = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param key the element to search for
     * @return the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(E key) {
        for (int index = 0; index < this.size; index++) {
            if (this.array[index].equals(key)) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Doubles the capacity of the array when it is full.
     */
    @SuppressWarnings("unchecked")
    private void enlarge() {
        E[] newArray = (E[]) new Object[2 * this.array.length];
        System.arraycopy(this.array, 0, newArray, 0, this.size);
        this.array = newArray;
    }

    /**
     * Checks if the index is within the valid range.
     *
     * @param index the index to check
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private void checkBoundaries(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    /**
     * Checks if the list is empty and throws an exception if it is.
     *
     * @throws IllegalStateException if the list is empty
     */
    private void checkEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("The list is empty");
        }
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int index = 0; index < this.size; index++) {
            sb.append(this.array[index]);
            if (index < this.size - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}