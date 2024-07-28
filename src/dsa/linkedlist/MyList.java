package dsa.linkedlist;

/**
 * Interface for a generic linked list.
 *
 * @param <E> the type of elements in this list
 * @author dangth2004
 * @since 2024-07-25
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
     * Returns the first node in the list.
     *
     * @return the first node in the list, or null if the list is empty
     */
    LinkedListNode<E> first();

    /**
     * Returns the last node in the list.
     *
     * @return the last node in the list, or null if the list is empty
     */
    LinkedListNode<E> last();

    /**
     * Adds a new node with the specified value at the end of the list.
     *
     * @param value the value to be added to the list
     */
    void add(E value);

    /**
     * Inserts a new node with the specified value at the given index.
     * Index starts from 0.
     *
     * @param value the value to be inserted
     * @param index the index at which the new node is to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    void insert(E value, int index);

    /**
     * Searches for the node containing the specified value.
     *
     * @param value the value to search for
     * @return the node containing the specified value, or null if not found
     */
    LinkedListNode<E> search(E value);

    /**
     * Returns the value of the node at the specified index.
     * Index starts from 0.
     *
     * @param index the index of the node whose value is to be returned
     * @return the value of the node at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    E get(int index);

    /**
     * Removes the node at the specified index.
     * Index starts from 0.
     *
     * @param index the index of the node to be removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    void remove(int index);
}