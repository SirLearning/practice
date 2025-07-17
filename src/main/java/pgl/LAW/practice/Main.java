package pgl.LAW.practice;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // printV4BamSize();
    }
    
    public static void printV4BamSize() throws IOException {
        FileInputStream is = new FileInputStream("D:\\Zheng\\Documents\\2_NBS\\Java\\LAW\\V4DB\\src\\test\\resources\\vmap4.bam.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        reader.readLine();
        int sum = 0;
        int num = 0;
        int line_num;
        while ((line = reader.readLine()) != null) {
            line_num = Integer.parseInt(line.split("G")[0].trim());
            sum += line_num;
            num += 1;
        }
        System.out.println(sum/num);
    }
}
