package dsa.arraylist;

/**
 * Interface for a generic array list.
 *
 * @param <E> the type of elements in this list
 */
public interface MyList<E> {
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    int size();

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements, false otherwise
     */
    boolean isEmpty();

    /**
     * Adds a new value at the end of the list.
     *
     * @param key the value to be added to the list
     */
    void add(E key);

    /**
     * Inserts a new value at the given index.
     * Index starts from 0.
     *
     * @param key   the value to be inserted
     * @param index the index at which the new value is to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    void insert(E key, int index);

    /**
     * Searches for the index of the specified value.
     *
     * @param key the value to search for
     * @return the index of the specified value, or -1 if not found
     */
    int search(E key);

    /**
     * Returns the value at the specified index.
     * Index starts from 0.
     *
     * @param index the index of the value to be returned
     * @return the value at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    E get(int index);

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param key   the element to be stored at the specified position
     * @param index the index of the element to replace
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    void set(E key, int index);

    /**
     * Removes the value at the specified index.
     * Index starts from 0.
     *
     * @param index the index of the value to be removed
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    void remove(int index);
}