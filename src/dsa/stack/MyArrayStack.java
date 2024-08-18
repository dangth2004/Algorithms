package dsa.stack;

import java.util.EmptyStackException;

public class MyArrayStack<E> implements MyStack<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] stack;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArrayStack() {
        this.stack = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyArrayStack(int capacity) {
        this.stack = (E[]) new Object[capacity];
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

    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public E pop() {
        return null;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public E peek() {
        return null;
    }
}
