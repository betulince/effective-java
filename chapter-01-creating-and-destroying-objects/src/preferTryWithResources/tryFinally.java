package preferTryWithResources;

import java.io.*;

/**
 * the java libraries include many resources that must be closed manually by invoking a close() method
 * ex; InputStream, OutputStream, java.sql.Connection
 * historically, a try-finally statement was the best way to guarantee that a resource would be closed properly, even
 * in the face of an exception or return
 *
 * the more you add resource to the below code, the more it gets worse as you can see in the second method
 */
public class tryFinally {
    /***
     * the code in both the try block and the finally block is capable of throwing exceptions. for example, the call to readLine
     * could throw an exception due to a failure in the underlying physical device, and the call to close could then fail for the same reason.
     * under these circumstances, the second exception completely obliterates the first one.
     * there is no record of the first exception in the exception stack trace, which can greatly complicate debugging in real systems - usually
     * it's the first exception you want to see in order to diagnose the problem.
     */
    private static int BUFFER_SIZE = 8 * 1024;
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        try {
            return reader.readLine();
        } finally {
            reader.close();
        }
    }

    static void copy(String source, String destination) throws IOException {
        InputStream in = new FileInputStream(source);
        try {
            OutputStream out = new FileOutputStream(destination);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
}
