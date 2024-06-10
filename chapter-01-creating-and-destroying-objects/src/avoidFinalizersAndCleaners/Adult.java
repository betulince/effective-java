package avoidFinalizersAndCleaners;

/**
 * If clients surround all room instantiations in try-with-resource blocks, automatic cleaning will never be required.
 * Adult program prints Goodbye! followed by Cleaning room.
 */
public class Adult {
    public static void main(String[] args) {
        try (Room room = new Room(7)) {
            System.out.println("Goodbye!");
        }
    }
}
