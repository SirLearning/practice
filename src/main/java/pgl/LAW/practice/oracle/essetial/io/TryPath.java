package pgl.LAW.practice.oracle.essetial.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TryPath {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("V4DB\\src\\test\\resources");
        Path path2 = Paths.get("D:\\Zheng\\Documents\\2_NBS\\Java\\LAW\\V4DB\\src\\test\\resources");
        // Path path = Paths.get("D:/Zheng/Documents/2_NBS/Java/LAW/V4DB/src/test/resources/");

        path1 = path1.toAbsolutePath();

        System.out.format("toString: %s%n", path1.toString());
        System.out.format("getFileName: %s%n", path1.getFileName());
        System.out.format("getName(0): %s%n", path1.getName(0));
        System.out.format("getNameCount: %d%n", path1.getNameCount());
        System.out.format("subpath(0,2): %s%n", path1.subpath(0,2));
        System.out.format("getParent: %s%n", path1.getParent());
        System.out.format("getRoot: %s%n", path1.getRoot());
        System.out.format("%s%n", path1.toUri());

        try {
            Path fp = path1.toRealPath();
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path1);
            // Logic for case when file doesn't exist.
        } catch (IOException x) {
            System.err.format("%s%n", x);
            // Logic for other sort of file error.
        }

        System.out.format("%s%n", path1.resolve("Wiews"));
        System.out.format("%s%n", path1);

        for (Path name: path1) {
            System.out.println(name);
        }

        if (Files.isSameFile(path1, path2)) {
            System.out.println("Same file/path");
        }
    }
}
