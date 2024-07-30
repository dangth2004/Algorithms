package dsa.stack;

/**
 * @param <E> the type of elements in this stack
 * @author dangth2004
 * @since 2024-07-30
 * <p>
 * An interface for a stack data structure.
 */
public interface MyStack<E> {

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    int size();

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param key the element to be pushed onto the stack
     */
    void push(E key);

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws java.util.EmptyStackException if the stack is empty
     */
    E pop();

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack
     * @throws java.util.EmptyStackException if the stack is empty
     */
    E top();
}