package pgl.LAW.practice.oracle.essetial.io;

import java.io.IOException;
import java.nio.file.*;

public class CreateDir {

    public static void main(String[] args) {
        Path dir = Paths.get("D:\\Zheng\\Documents\\2_NBS\\Java\\LAW\\practice\\src\\main\\resources");
        // classic(dir);
        useFilter(dir);
    }

    public static void classic(Path dir) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file: stream) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }
    }

    public static void glob(Path dir) {
        try (DirectoryStream<Path> stream =
                     Files.newDirectoryStream(dir, "*.{java,class,jar}")) {
            for (Path entry: stream) {
                System.out.println(entry.getFileName());
            }
        } catch (IOException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can // only be thrown by newDirectoryStream.
            System.err.println(x);
        }
    }

    public static void useFilter(Path dir) {
        DirectoryStream.Filter<Path> filter =
                new DirectoryStream.Filter<Path>() {
                    public boolean accept(Path file) {
                        return (Files.isDirectory(file));
                    }
                };

        try (DirectoryStream<Path>
                     stream = Files.newDirectoryStream(dir, filter)) {
            for (Path entry: stream) {
                System.out.println(entry.getFileName());
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}
