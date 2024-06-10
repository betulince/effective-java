package avoidFinalizersAndCleaners;

import java.lang.ref.Cleaner;

/**
 * What should you do instead of writing a finalizer or cleaner for a class whose objects encapsulate
 * resources that require termination, such as files or threads? Just have your class implement
 * AutoCloseable (ensures prompt release) and require its clients to invoke the close method on
 * each instance when it is no longer needed, typically using try-with-resources to ensure termination
 * even in the face of exceptions.
 * finalizers/cleaners legitimate uses:
 * 1. as a safety net
 * some java library classes, such as FileInputStream, FileOutputStream, ThreadPoolExecutor, java.sql.Connection,
 * have finalizers that serve as safety nets.
 *
 * Let's assume that rooms must be cleaned before they are reclaimed.
 *
 * The code illustrates how to use the Cleaner class from the Java standard library to ensure that resources are
 * properly released, even if the client forgets to call the close method.
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

/**
 * Does your class manage resources that need explicit cleanup (e.g., file handles, sockets)?
 *
 * Yes: Implement AutoCloseable and provide a close method.
 * No: No need for special resource management.
 * Is prompt release of the resource critical?
 *
 * Yes: Ensure clients use try-with-resources or explicitly call close.
 * No: Consider using a cleaner as a safety net in addition to the close method.
 * Can clients reliably be expected to call close?
 *
 * Yes: Rely on AutoCloseable and try-with-resources.
 * No: Implement a cleaner as a safety net to handle missed close calls.
 */
