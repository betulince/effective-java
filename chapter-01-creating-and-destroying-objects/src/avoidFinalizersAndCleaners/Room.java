package avoidFinalizersAndCleaners;

import java.lang.ref.Cleaner;

/**
 * Let's assume that rooms must be cleaned before they are reclaimed.
 */
public class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();

    // Resource that requires cleaning. Must not refer to Room!
    private static class State implements Runnable {
        int numJunkPiles; // Resource that requires cleaning
        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        // Invoked by close method or cleaner
        @Override
        public void run() { // cleanup logic
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

    // The state of this room, shared with our cleanable
    private final State state; // Holds the number of junk piles in the room

    // Our cleanable. Cleans the room when it's eligible for garbage collection
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() {
        cleanable.clean();
    }

    public static void main(String[] args) {
        try (Room room = new Room(5)) {
            System.out.println("Room created with 5 junk piles.");
        }

        Room anotherRoom = new Room(10);
        System.out.println("Room created with 10 junk piles.");
        anotherRoom = null;

        System.gc();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
