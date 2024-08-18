package dsa.stack;

import java.util.EmptyStackException;

public class MyArrayStack<E> implements MyStack<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int size;

    /**
     * Constructs an empty stack.
     */
    @SuppressWarnings("unchecked")
    public MyArrayStack() {
        this.array = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Constructs an empty stack with given capacity
     */
    @SuppressWarnings("unchecked")
    public MyArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param key the element to be pushed onto the stack
     */
    @Override
    public void push(E key) {
        if (this.size == this.array.length) {
            enlarge();
        }
        this.array[this.size] = key;
        this.size++;
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E top = this.array[this.size - 1];
        this.array[this.size - 1] = null;
        this.size--;
        return top;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return this.array[this.size - 1];
    }

    /**
     * Returns a string representation of the stack.
     *
     * @return a string representation of the stack
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

    /**
     * Doubles the capacity of the array when it is full.
     */
    @SuppressWarnings("unchecked")
    private void enlarge() {
        E[] newStack = (E[]) new Object[2 * this.array.length];
        System.arraycopy(this.array, 0, newStack, 0, this.size);
        this.array = newStack;
    }
}