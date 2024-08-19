package dsa.queue;

public class MyArrayQueue<E> implements MyQueue<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int size;
    private int first;
    private int last;

    /**
     * Constructs an empty queue.
     */
    @SuppressWarnings("unchecked")
    public MyArrayQueue() {
        this.array = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.first = 0;
        this.last = 0;
    }

    /**
     * Constructs an empty queue with given capacity
     *
     * @param capacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified capacity is negative
     */
    @SuppressWarnings("unchecked")
    public MyArrayQueue(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        this.array = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * Doubles the capacity of the array when it is full.
     */
    private void enlarge() {
        E[] newArray = (E[]) new Object[2 * this.array.length];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(first + i) % array.length];
        }
        this.array = newArray;
        this.first = 0;
        this.last = size;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    @Override
    public E first() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty");
        }
        return this.array[this.first];
    }

    /**
     * Adds an element to the end of the queue.
     *
     * @param value the element to be added to the queue
     */
    @Override
    public void enqueue(E value) {
        if (this.size == this.array.length) {
            enlarge();
        }
        this.array[this.last] = value;
        this.last = (this.last + 1) % this.array.length;
        this.size++;
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty");
        }
        E element = this.array[this.first];
        this.array[this.first] = null;
        this.first = (this.first + 1) % this.array.length;
        this.size--;
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
        for (int index = 0; index < size; index++) {
            string.append(array[(first + index) % array.length]);
            if (index != size - 1) {
                string.append(" -> ");
            }
        }
        return string.toString();
    }
}
