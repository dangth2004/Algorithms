package dsa.linkedlist;

/**
 * @param <E> the type of element held in this node
 * @author dangth2004
 * @since 2024-07-25
 * Node class for a doubly linked list.
 */
public class LinkedListNode<E> {
    private E key;
    private LinkedListNode<E> next;
    private LinkedListNode<E> previous;

    /**
     * Constructs a new node with the specified key.
     *
     * @param key the key stored in the node
     */
    public LinkedListNode(E key) {
        this.key = key;
        this.next = null;
        this.previous = null;
    }

    /**
     * Constructs a new node with the specified key, next node, and previous node.
     *
     * @param key      the key stored in the node
     * @param next     the next node in the list
     * @param previous the previous node in the list
     */
    public LinkedListNode(E key, LinkedListNode<E> next, LinkedListNode<E> previous) {
        this.key = key;
        this.next = next;
        this.previous = previous;
    }

    /**
     * Returns the key stored in the node.
     *
     * @return the key stored in the node
     */
    public E getKey() {
        return this.key;
    }

    /**
     * Returns the next node in the list.
     *
     * @return the next node in the list, or null if there is no next node
     */
    public LinkedListNode<E> getNext() {
        return this.next;
    }

    /**
     * Returns the previous node in the list.
     *
     * @return the previous node in the list, or null if there is no previous node
     */
    public LinkedListNode<E> getPrevious() {
        return this.previous;
    }

    /**
     * Sets the key stored in the node.
     *
     * @param key the new key to be stored in the node
     */
    public void setKey(E key) {
        this.key = key;
    }

    /**
     * Sets the next node in the list.
     *
     * @param node the new next node in the list
     */
    public void setNext(LinkedListNode<E> node) {
        this.next = node;
    }

    /**
     * Sets the previous node in the list.
     *
     * @param node the new previous node in the list
     */
    public void setPrevious(LinkedListNode<E> node) {
        this.previous = node;
    }
}