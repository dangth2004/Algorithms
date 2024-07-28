package dsa.linkedlist;

/**
 * @param <E> the type of elements in this list
 * @author dangth2004
 * @since 2024-07-25
 *
 * Implementation of a doubly linked list.
 */

public class MyLinkedList<E> implements MyList<E> {
    private LinkedListNode<E> head;
    private int size = 0;

    /**
     * Constructs an empty list.
     */
    public MyLinkedList() {

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
        try {
            if (isEmpty()) {
                this.head = new LinkedListNode<>(key);
                this.size++;
                return;
            }

            if (index == 0) {
                // Insert a new node to the first of the list
                LinkedListNode<E> node = new LinkedListNode<>(key);
                node.setNext(this.head);
                this.head.setPrevious(node);
                this.head = node;
            } else if (index == this.size) {
                // Insert a new node to the last of the list
                LinkedListNode<E> node = last();
                LinkedListNode<E> newNode = new LinkedListNode<>(key);
                node.setNext(newNode);
                newNode.setPrevious(node);
            } else {
                LinkedListNode<E> prevNode = nodeAtIndex(index - 1);
                LinkedListNode<E> nextNode = prevNode.getNext();
                LinkedListNode<E> newNode = new LinkedListNode<>(key, nextNode, prevNode);
                nextNode.setPrevious(newNode);
                prevNode.setNext(newNode);
            }
            this.size++;
        } catch (Exception e) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
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
        while (node != null && node.getKey() != key) {
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
        try {
            return nodeAtIndex(index).getKey();
        } catch (Exception e) {
            throw new IndexOutOfBoundsException("Invalid index. Index may" +
                    " smaller than 0 or greater than the size of the list");
        }
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
        try {
            if (isEmpty()) {
                System.out.println("The list is already empty");
            } else if (this.size == 1) {
                this.head = null;
                this.size--;
                System.out.println("The list is empty");
            } else {
                if (index == 0) {
                    // Remove the first node
                    LinkedListNode<E> newHead = this.head.getNext();
                    this.head.setNext(null);
                    newHead.setPrevious(null);
                    this.head = newHead;
                } else if (index + 1 == this.size) {
                    // Remove the last node
                    LinkedListNode<E> node = this.head;
                    while (node.getNext().getNext() != null) {
                        node = node.getNext();
                    }
                    LinkedListNode<E> lastNode = node.getNext();
                    node.setNext(null);
                    lastNode.setPrevious(null);
                } else {
                    LinkedListNode<E> node = nodeAtIndex(index);
                    LinkedListNode<E> prevNode = node.getPrevious();
                    LinkedListNode<E> nextNode = node.getNext();
                    node.setNext(null);
                    node.setPrevious(null);
                    prevNode.setNext(nextNode);
                    nextNode.setPrevious(prevNode);
                }
                this.size--;
            }
        } catch (Exception e) {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list
     */
    public String toString() {
        StringBuilder string = new StringBuilder();
        LinkedListNode<E> node = this.head;
        while (node != null) {
            if (node.getNext() == null) {
                string.append(node.getKey());
            } else {
                string.append(node.getKey()).append(" -> ");
            }
            node = node.getNext();
        }
        return String.valueOf(string);
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
        try {
            LinkedListNode<E> node = this.head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            return node;
        } catch (Exception e) {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
    }
}