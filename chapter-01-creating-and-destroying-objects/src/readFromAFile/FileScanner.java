package readFromAFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileScanner {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = FileScanner.class.getClassLoader();
        // otherwise I have to give the absolute path
        // Path filePath = Paths.get("/Users/bince/Desktop/personal-projects/effective-java/chapter-01-creating-and-destroying-objects/src/readFromAFile/text.txt");
        URL resource = classLoader.getResource("readFromAFile/text.txt");

        if (resource == null) {
            System.out.println("File not found");
            return;
        }

        try {
            Path filePath = Paths.get(resource.toURI());
            try (Scanner fileScanner = new Scanner(filePath)) {
                while (fileScanner.hasNext()) {
                    String row = fileScanner.nextLine();
                    System.out.println(row);
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } catch (URISyntaxException e) {
            System.out.println("Error converting URL to URI: " + e.getMessage());
        }
    }
}