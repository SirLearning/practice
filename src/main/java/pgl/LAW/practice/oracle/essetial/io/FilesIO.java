package pgl.LAW.practice.oracle.essetial.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesIO {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("D:\\Zheng\\Documents\\2_NBS\\Java\\LAW\\practice\\src\\main\\resources\\xanadu.txt");
        readAll(file);
        bufferIO(file);
    }

    public static void readAll(Path file) throws IOException {
        byte[] fileArray;
        fileArray = Files.readAllBytes(file);
        byte[] buf = {1, 0};
        Files.write(file, buf);
    }

    public static void bufferIO(Path file) {
        try (InputStream in = Files.newInputStream(file);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    public static void readFile(Path path) throws IOException {

        // Files.newByteChannel() defaults to StandardOpenOption.READ
        try (SeekableByteChannel sbc = Files.newByteChannel(path)) {
            final int BUFFER_CAPACITY = 10;
            ByteBuffer buf = ByteBuffer.allocate(BUFFER_CAPACITY);

            // Read the bytes with the proper encoding for this platform. If
            // you skip this step, you might see foreign or illegible
            // characters.
            String encoding = System.getProperty("file.encoding");
            while (sbc.read(buf) > 0) {
                buf.flip();
                System.out.print(Charset.forName(encoding).decode(buf));
                buf.clear();
            }
        }
    }

    public static void createFile(Path file) {
        try {
            // Create the empty file with default permissions, etc.
            Files.createFile(file);
            // Create temporary file
            Path tempFile = Files.createTempFile(null, ".myapp");
            System.out.format("The temporary file" +
                    " has been created: %s%n", tempFile);
        } catch (FileAlreadyExistsException x) {
            System.err.format("file named %s" +
                    " already exists%n", file);
        } catch (IOException x) {
            // Some other sort of failure, such as permissions.
            System.err.format("createFile error: %s%n", x);
        }
    }
}
