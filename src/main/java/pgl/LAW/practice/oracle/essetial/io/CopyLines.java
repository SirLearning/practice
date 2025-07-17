package pgl.LAW.practice.oracle.essetial.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class CopyLines {
    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;
        String practiceRes = "practice/src/main/resources/";

        try {
            inputStream = new BufferedReader(new FileReader(practiceRes + "xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter(practiceRes + "lineoutput.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
