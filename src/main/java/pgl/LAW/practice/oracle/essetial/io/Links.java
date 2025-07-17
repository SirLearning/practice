package pgl.LAW.practice.oracle.essetial.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Links {
    public static void main(String[] args) {
        Path softLink = Paths.get("D:\\Zheng\\Documents\\2_NBS\\Java\\LAW\\practice\\src\\main\\resources\\testDir\\soft.txt");
        Path hardLink = Paths.get("D:\\Zheng\\Documents\\2_NBS\\Java\\LAW\\practice\\src\\main\\resources\\testDir\\hard.txt");
        Path target = Paths.get("D:\\Zheng\\Documents\\2_NBS\\Java\\LAW\\practice\\src\\main\\resources\\xanadu.txt");
        createSoftLink(softLink, target);
        createHardLink(hardLink, target);
        // detect a symbolic link
        boolean isSymbolicLink = Files.isSymbolicLink(softLink);
        // find target of a symbolic link
        try {
            System.out.format("Target of link" +
                            " '%s' is '%s'%n", softLink,
                    Files.readSymbolicLink(softLink));
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    public static void createSoftLink(Path newLink, Path target) {
        try {
            Files.createSymbolicLink(newLink, target);
        } catch (IOException x) {
            System.err.println(x);
        } catch (UnsupportedOperationException x) {
            // Some file systems do not support symbolic links.
            System.err.println(x);
        }
    }

    public static void createHardLink(Path newLink, Path target) {
        try {
            Files.createLink(newLink, target);
        } catch (IOException x) {
            System.err.println(x);
        } catch (UnsupportedOperationException x) {
            // Some file systems do not
            // support adding an existing
            // file to a directory.
            System.err.println(x);
        }
    }
}
