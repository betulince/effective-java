package avoidFinalizersAndCleaners.tryWithResources;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * try-with-resources allows us to declare resources to be used in a try block with the assurance that the resources
 * will be closed after the execution of that block.
 * a resource has to be both declared and initialized inside the try.
 * the resources declared need to implement the AutoCloseable interface
 */
public class tryWithResources {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("./chapter-01-creating-and-destroying-objects/src" +
                "/avoidFinalizersAndCleaners/tryWithResources/test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
}
