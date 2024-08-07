package dsa.list;

/**
 * Represents a node in a doubly linked list.
 *
 * @param <E> the type of element held in this node
 */
public class MyLinkedListNode<E> {
    private MyLinkedListNode<E> next;
    private MyLinkedListNode<E> previous;
    private E key;

    /**
     * Constructs a new node with the specified key.
     * The node's next and previous references are set to null.
     *
     * @param key the element to be stored in this node
     */
    public MyLinkedListNode(E key) {
        this.key = key;
        this.next = null;
        this.previous = null;
    }

    /**
     * Constructs a new node with the specified key, next node, and previous node.
     *
     * @param key the element to be stored in this node
     * @param next the next node in the list
     * @param previous the previous node in the list
     */
    public MyLinkedListNode(E key, MyLinkedListNode<E> next, MyLinkedListNode<E> previous) {
        this.key = key;
        this.next = next;
        this.previous = previous;
    }

    /**
     * Returns the next node in the list.
     *
     * @return the next node in the list, or null if there is no next node
     */
    public MyLinkedListNode<E> getNext() {
        return this.next;
    }

    /**
     * Sets the next node in the list.
     *
     * @param next the next node to be set
     */
    public void setNext(MyLinkedListNode<E> next) {
        this.next = next;
    }

    /**
     * Returns the previous node in the list.
     *
     * @return the previous node in the list, or null if there is no previous node
     */
    public MyLinkedListNode<E> getPrevious() {
        return this.previous;
    }

    /**
     * Sets the previous node in the list.
     *
     * @param previous the previous node to be set
     */
    public void setPrevious(MyLinkedListNode<E> previous) {
        this.previous = previous;
    }

    /**
     * Returns the element stored in this node.
     *
     * @return the element stored in this node
     */
    public E getKey() {
        return this.key;
    }

    /**
     * Sets the element stored in this node.
     *
     * @param key the element to be set
     */
    public void setKey(E key) {
        this.key = key;
    }
}
