package dsa.queue;

import java.util.LinkedList;
import java.util.List;

/**
 * @param <E> the type of elements in this stack
 * @author dangth2004
 * @since 2024-08-06
 * <p>
 * Implementation of a queue using a linked list.
 */
public class MyLinkedListQueue<E> implements MyQueue<E> {
    private final List<E> list;

    /**
     * Constructs an empty stack.
     */
    public MyLinkedListQueue() {
        this.list = new LinkedList<>();
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    @Override
    public int size() {
        return this.list.size();
    }

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue, or null if the queue is empty
     */
    @Override
    public E first() {
        return this.list.getFirst();
    }

    /**
     * Adds an element to the end of the queue.
     *
     * @param value the element to be added to the queue
     */
    @Override
    public void enqueue(E value) {
        this.list.addLast(value);
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue, or null if the queue is empty
     */
    @Override
    public E dequeue() {
        E first = this.list.getFirst();
        this.list.removeFirst();
        return first;
    }

    /**
     * Returns a string representation of the queue.
     *
     * @return a string representation of the queue
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int index = 0; index < list.size(); index++) {
            string.append(list.get(index));
            if (index != list.size() - 1) {
                string.append(" -> ");
            }
        }
        return string.toString();
    }
}