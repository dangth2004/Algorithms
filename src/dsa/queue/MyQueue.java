package dsa.queue;

/**
 * Interface for a generic queue.
 *
 * @param <E> the type of elements in this queue
 * @author dangth2004
 * @since 2024-08-06
 * <p>
 */
public interface MyQueue<E> {
    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    int size();

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue, or null if the queue is empty
     */
    E first();

    /**
     * Adds an element to the end of the queue.
     *
     * @param value the element to be added to the queue
     */
    void enqueue(E value);

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue, or null if the queue is empty
     */
    E dequeue();
}