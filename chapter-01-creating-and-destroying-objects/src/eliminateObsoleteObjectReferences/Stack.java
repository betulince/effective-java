package eliminateObsoleteObjectReferences;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 *There is obviously nothing wrong with this program. You could test it exhaustively, and it would pass every test with flying colors,
 * but there's a problem lurking. The program has a "memory leak"
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    /**
     * ensure space for at least one more element, roughly doubling the capacity each time the array needs to grow
     */
    public void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
