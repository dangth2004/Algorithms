package dsa.linkedlist;

/**
 * @param <E> the type of elements in this list
 * @author dangth2004
 * @since 2024-07-25
 * <p>
 * Implementation of a doubly linked list.
 */

public class MyLinkedList<E> implements MyList<E> {
    private LinkedListNode<E> head;
    private int size;

    /**
     * Constructs an empty list.
     */
    public MyLinkedList() {
        this.head = null;
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
     * Returns the first node in the list.
     *
     * @return the first node in the list, or null if the list is empty
     */
    @Override
    public LinkedListNode<E> first() {
        return this.head;
    }

    /**
     * Returns the last node in the list.
     *
     * @return the last node in the list, or null if the list is empty
     */
    @Override
    public LinkedListNode<E> last() {
        if (isEmpty()) {
            return null;
        }

        LinkedListNode<E> node = this.head;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        return node;
    }

    /**
     * Adds a new node with the specified value at the end of the list.
     *
     * @param key the value to be added to the list
     */
    @Override
    public void add(E key) {
        if (isEmpty()) {
            this.head = new LinkedListNode<>(key);
        } else {
            LinkedListNode<E> node = last();
            LinkedListNode<E> newNode = new LinkedListNode<>(key);
            node.setNext(newNode);
            newNode.setPrevious(node);
        }
        this.size++;
    }

    /**
     * Inserts a new node with the specified value at the given index.
     * Index starts from 0.
     *
     * @param key   the value to be inserted
     * @param index the index at which the new node is to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void insert(E key, int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            LinkedListNode<E> newNode = new LinkedListNode<>(key);
            newNode.setNext(this.head);
            if (this.head != null) {
                this.head.setPrevious(newNode);
            }
            this.head = newNode;
        } else {
            LinkedListNode<E> prevNode = nodeAtIndex(index - 1);
            LinkedListNode<E> nextNode = prevNode.getNext();
            LinkedListNode<E> newNode = new LinkedListNode<>(key);
            newNode.setNext(nextNode);
            newNode.setPrevious(prevNode);
            prevNode.setNext(newNode);
            if (nextNode != null) {
                nextNode.setPrevious(newNode);
            }
        }
        this.size++;
    }

    /**
     * Searches for the node containing the specified value.
     *
     * @param key the value to search for
     * @return the node containing the specified value, or null if not found
     */
    @Override
    public LinkedListNode<E> search(E key) {
        LinkedListNode<E> node = this.head;
        while (node != null && !node.getKey().equals(key)) {
            node = node.getNext();
        }
        return node;
    }

    /**
     * Returns the value of the node at the specified index.
     * Index starts from 0.
     *
     * @param index the index of the node whose value is to be returned
     * @return the value of the node at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E get(int index) {
        return nodeAtIndex(index).getKey();
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
        nodeAtIndex(index).setKey(key);
    }

    /**
     * Removes the node at the specified index.
     * Index starts from 0.
     *
     * @param index the index of the node to be removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void remove(int index) {
        checkBoundaries(index);

        if (index == 0) {
            this.head = this.head.getNext();
            if (this.head != null) {
                this.head.setPrevious(null);
            }
        } else {
            LinkedListNode<E> node = nodeAtIndex(index);
            LinkedListNode<E> prevNode = node.getPrevious();
            LinkedListNode<E> nextNode = node.getNext();
            prevNode.setNext(nextNode);
            if (nextNode != null) {
                nextNode.setPrevious(prevNode);
            }
        }
        this.size--;
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        LinkedListNode<E> node = this.head;
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
    private LinkedListNode<E> nodeAtIndex(int index) {
        checkBoundaries(index);

        LinkedListNode<E> node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
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
}