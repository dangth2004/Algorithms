package dsa.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Implementation of a queue using a linked list.
 *
 * @param <E> the type of elements in this queue
 * @since 2024-08-06
 */
public class MyLinkedListQueue<E> implements MyQueue<E> {
    private final Deque<E> deque;

    /**
     * Constructs an empty queue.
     */
    public MyLinkedListQueue() {
        this.deque = new LinkedList<>();
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.deque.isEmpty();
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    @Override
    public int size() {
        return this.deque.size();
    }

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public E first() {
        E element = this.deque.peekFirst();
        if (element == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        return element;
    }

    /**
     * Adds an element to the end of the queue.
     *
     * @param value the element to be added to the queue
     */
    @Override
    public void enqueue(E value) {
        this.deque.addLast(value);
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public E dequeue() {
        E element = this.deque.pollFirst();
        if (element == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        return element;
    }

    /**
     * Returns a string representation of the queue.
     *
     * @return a string representation of the queue
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (E element : deque) {
            string.append(element).append(" -> ");
        }
        if (string.length() > 0) {
            string.setLength(string.length() - 4); // Remove trailing " -> "
        }
        return string.toString();
    }
}
