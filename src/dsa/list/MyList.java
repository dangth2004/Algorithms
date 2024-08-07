package dsa.list;

/**
 * Interface for a generic list.
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
     * Adds a new element with the specified value at the end of the list.
     *
     * @param key the value to be added to the list
     */
    void add(E key);

    /**
     * Adds a new element with the specified value at the given index.
     * Index starts from 0.
     *
     * @param key   the value to be added
     * @param index the index at which the new element is to be added
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    void add(E key, int index);

    /**
     * Adds a new element with the specified value at the beginning of the list.
     *
     * @param key the value to be added
     */
    void addFirst(E key);

    /**
     * Adds a new element with the specified value at the end of the list.
     *
     * @param key the value to be added
     */
    void addLast(E key);

    /**
     * Returns true if this list contains the specified element.
     *
     * @param key the value to search for
     * @return true if the list contains the specified element, false otherwise
     */
    boolean contains(E key);

    /**
     * Returns the value of the element at the specified index.
     * Index starts from 0.
     *
     * @param index the index of the element whose value is to be returned
     * @return the value of the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    E get(int index);

    /**
     * Returns the value of the first element in the list.
     *
     * @return the value of the first element in the list
     */
    E getFirst();

    /**
     * Returns the value of the last element in the list.
     *
     * @return the value of the last element in the list
     */
    E getLast();

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param key   the element to be stored at the specified position
     * @param index the index of the element to replace
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    void set(E key, int index);

    /**
     * Removes the element at the specified index.
     * Index starts from 0.
     *
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    void remove(int index);

    /**
     * Removes and returns the first element of the list.
     *
     * @return the first element of the list
     */
    E removeFirst();

    /**
     * Removes and returns the last element of the list.
     *
     * @return the last element of the list
     */
    E removeLast();

    /**
     * Removes all elements from the list.
     */
    void clear();

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param key the element to search for
     * @return the index of the first occurrence of the specified element in this list,
     *         or -1 if this list does not contain the element
     */
    int indexOf(E key);
}