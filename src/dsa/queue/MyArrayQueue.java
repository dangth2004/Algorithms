package dsa.queue;

public class MyArrayQueue<E> implements MyQueue<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int size;

    public MyArrayQueue() {
        this.array = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Doubles the capacity of the array when it is full.
     */
    private void enlarge() {
        E[] newArray = (E[]) new Object[2 * this.array.length];
        System.arraycopy(this.array, 0, newArray, 0, this.size);
        this.array = newArray;
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
     * @return the element at the front of the queue, or null if the queue is empty
     */
    @Override
    public E first() {
        return this.array[0];
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
        this.array[this.size] = value;
        this.size++;
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue, or null if the queue is empty
     */
    @Override
    public E dequeue() {
        E first = this.array[0];
        this.size--;
        this.array[0] = null;
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
        for (int index = 0; index < this.size; index++) {
            string.append(this.array[index]);
            if (index != this.size - 1) {
                string.append(" -> ");
            }
        }
        return string.toString();
    }
}
