package dsa.list;

public class MyLinkedList<E> implements MyList<E> {
    private MyLinkedListNode<E> head;
    private MyLinkedListNode<E> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
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

    }

    /**
     * Adds a new element with the specified value at the beginning of the list.
     *
     * @param key the value to be added
     */
    @Override
    public void addFirst(E key) {

    }

    /**
     * Adds a new element with the specified value at the end of the list.
     *
     * @param key the value to be added
     */
    @Override
    public void addLast(E key) {

    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param key the value to search for
     * @return true if the list contains the specified element, false otherwise
     */
    @Override
    public boolean contains(E key) {
        MyLinkedListNode<E> node = this.head;
        while (node != null) {
            if (node.getKey().equals(key)) {
                return true;
            }
            node = node.getNext();
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
        checkBoundaries(index);
        checkEmpty();
        return nodeAtIndex(index).getKey();
    }

    /**
     * Returns the value of the first element in the list.
     *
     * @return the value of the first element in the list
     */
    @Override
    public E getFirst() {
        checkEmpty();
        return this.head.getKey();
    }

    /**
     * Returns the value of the last element in the list.
     *
     * @return the value of the last element in the list
     */
    @Override
    public E getLast() {
        checkEmpty();
        return this.tail.getKey();
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
        checkEmpty();
        nodeAtIndex(index).setKey(key);
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

    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the first element of the list
     */
    @Override
    public E removeFirst() {
        return null;
    }

    /**
     * Removes and returns the last element of the list.
     *
     * @return the last element of the list
     */
    @Override
    public E removeLast() {
        return null;
    }

    /**
     * Removes all elements from the list.
     */
    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
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
        int index = 0;
        MyLinkedListNode<E> node = this.head;
        while (node != null) {
            if (node.getKey().equals(key)) {
                return index;
            }
            node = node.getNext();
        }
        return -1;
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        MyLinkedListNode<E> node = this.head;
        while (node != null) {
            string.append(node.getKey());
            if (node.getNext() != null) {
                string.append(" -> ");
            }
            node = node.getNext();
        }
        return string.toString();
    }

    /**
     * Returns the node at the specified index.
     * Index starts from 0.
     *
     * @param index the index of the node to be returned
     * @return the node at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private MyLinkedListNode<E> nodeAtIndex(int index) {
        checkBoundaries(index);

        MyLinkedListNode<E> node;
        if (index < this.size / 2) {
            node = this.head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
        } else {
            node = this.tail;
            for (int i = this.size - 1; i > index; i--) {
                node = node.getPrevious();
            }
        }
        return node;
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
}