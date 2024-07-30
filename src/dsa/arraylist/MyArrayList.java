package dsa.arraylist;

public class MyArrayList<E> implements MyList<E> {
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Adds a new value at the end of the list.
     *
     * @param key the value to be added to the list
     */
    @Override
    public void add(E key) {

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

    }

    /**
     * Searches for the index the specified value.
     *
     * @param key the value to search for
     * @return the index of the specified value, or -1 if not found
     */
    @Override
    public int search(E key) {
        return 0;
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
        return null;
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

    }
}
