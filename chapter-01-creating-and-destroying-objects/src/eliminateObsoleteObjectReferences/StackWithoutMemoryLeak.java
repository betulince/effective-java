package eliminateObsoleteObjectReferences;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * if an object reference is unintentionally retained, not only is that object excluded from garbage collection,
 * but so too are any objects referenced by that object , and so on.
 */
public class StackWithoutMemoryLeak {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackWithoutMemoryLeak() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * the reference to an item becomes obsolete as soon as it's popped off the stack
     * so null out the obsolete references
     * @return Object
     */
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    /**
     * ensure space for at least one more element, roughly doubling the capacity each time the array needs to grow
     */
    public void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        StackWithoutMemoryLeak stack = new StackWithoutMemoryLeak();

        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Cannot pop from an empty stack.");
        }
    }
}
