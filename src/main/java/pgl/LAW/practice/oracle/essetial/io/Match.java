package pgl.LAW.practice.oracle.essetial.io;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class Match {
    public static void main(String[] args) {
        PathMatcher matcher =
                FileSystems.getDefault().getPathMatcher("glob:*.{java,class}");

        Path file = Paths.get("D:\\Zheng\\Documents\\2_NBS\\Java\\LAW\\practice\\src\\main\\java\\pgl\\LAW\\practice\\oracle\\essetial\\io\\Match.java");
        if (matcher.matches(file)) {
            System.out.println(file);
        }
    }
}
