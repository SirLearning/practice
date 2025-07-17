package pgl.LAW.practice.oracle.essetial.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String practiceRes = "practice/src/main/resources/";

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(practiceRes + "xanadu.txt");
            out = new FileOutputStream(practiceRes + "outagain.txt");
            // try no path, won't work
//            in = new FileInputStream("xanadu.txt");
//            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
