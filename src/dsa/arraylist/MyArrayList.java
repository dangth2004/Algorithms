package dsa.arraylist;

/**
 * @param <E> the type of elements in this list
 * @author dangth2004
 * @since 2024-07-30
 * <p>
 * Implementation of an array list.
 */

public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int size;

    /**
     * Constructs an empty list.
     */
    public MyArrayList() {
        this.array = (E[]) new Object[DEFAULT_CAPACITY];
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
     * Adds a new value at the end of the list.
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
     * Inserts a new value at the given index.
     * Index starts from 0.
     *
     * @param key   the value to be inserted
     * @param index the index at which the new value is to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void insert(E key, int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (this.size == this.array.length) {
            enlarge();
        }

        E[] rightArray = (E[]) new Object[this.size - index];
        System.arraycopy(this.array, index, rightArray, 0, rightArray.length);
        this.array[index] = key;
        System.arraycopy(rightArray, 0, array, index + 1, rightArray.length);
        this.size++;
    }

    /**
     * Searches for the index the specified value.
     *
     * @param key the value to search for
     * @return the index of the specified value, or -1 if not found
     */
    @Override
    public int search(E key) {
        for (int index = 0; index < this.size; index++) {
            if (this.array[index].equals(key)) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Returns the value at the specified index.
     * Index starts from 0.
     *
     * @param index the index of the value is to be returned
     * @return the value at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E get(int index) {
        checkBoundaries(index);
        return this.array[index];
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
     * Removes the value at the specified index.
     * Index starts from 0.
     *
     * @param index the index of the value to be removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void remove(int index) {
        checkBoundaries(index);
        if (isEmpty()) {
            throw new ArrayStoreException("The list is empty");
        } else {
            E[] newArray = (E[]) new Object[this.size - 1];
            System.arraycopy(this.array, 0, newArray, 0, index);
            System.arraycopy(this.array, index + 1, newArray, index, newArray.length - index);
            this.array = newArray;
            this.size--;
        }
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list
     */
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int index = 0; index < this.size; index++) {
            string.append(this.array[index]);
            if (index != this.size - 1) {
                string.append(" -> ");
            }
        }
        return string.toString();
    }

    /**
     * Doubles the capacity of the array list.
     */
    private void enlarge() {
        E[] newArray = (E[]) new Object[2 * this.size];
        System.arraycopy(array, 0, newArray, 0, this.size);
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
}