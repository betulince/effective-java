package preferTryWithResources;

import java.io.*;

/**
 * to be usable with this construct, a resource must implement AutoCloseable interface, which consists of a single void
 * returning close method. many classes and interfaces in the java libraries and in third-party libraries now implement
 * or extend AutoCloseable. if you write a class that represents a resource that must be closed, your class should implement
 * AutoCloseable too.
 */
public class tryWithResources {
    /***
     * if exceptions are thrown by both the readLine call and the invisible close, the latter exception is suppressed in
     * favor of the former. in fact, multiple exceptions may be suppressed in order to preserve the exception that you actually
     * want to see.
     */
    private static final int BUFFER_SIZE = 8 * 1024;
    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            return reader.readLine();
        }
    }

    static void copy(String source, String destination) throws IOException {
        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(destination)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }
}
