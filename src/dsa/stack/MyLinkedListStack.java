package dsa.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;


/**
 * Implementation of a stack using a linked list.
 *
 * @param <E> the type of elements in this stack
 */
public class MyLinkedListStack<E> implements MyStack<E> {
    private List<E> list;

    /**
     * Constructs an empty stack.
     */
    public MyLinkedListStack() {
        this.list = new LinkedList<>();
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    @Override
    public int size() {
        return this.list.size();
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param key the element to be pushed onto the stack
     */
    @Override
    public void push(E key) {
        this.list.addFirst(key);
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public E pop() {
        E top = list.getFirst();
        list.removeFirst();
        return top;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public E top() {
        return list.getFirst();
    }

    /**
     * Returns a string representation of the stack.
     *
     * @return a string representation of the stack
     */
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