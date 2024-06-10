package avoidFinalizersAndCleaners;

/**
 * Teenager program never prints Cleaning room; it just exists.
 * No guarantees are made relating to whether cleaning actions are invoked or not.
 * adding System.gc() might be enough to make it print Cleaning room, but it differs per machine.
 * In summary;
 * Do not use cleaners or in releases prior to Java 9, finalizers, except as a safety net or to terminate noncritical native resources.
 */
public class Teenager {
    public static void main(String[] args) {
        new Room(99);
        System.out.println("Peace out!");
    }
}
