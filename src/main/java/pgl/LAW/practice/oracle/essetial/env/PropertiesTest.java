package pgl.LAW.practice.oracle.essetial.env;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args)
            throws Exception {

        // set up new properties object
        // from file "myProperties.txt"
        FileInputStream propFile =
                new FileInputStream( "D:\\Zheng\\Documents\\2_NBS\\Java\\LAW\\practice\\src\\main\\resources\\myProterties.txt");
        Properties p =
                new Properties(System.getProperties());
        p.load(propFile);

        // set the system properties
        System.setProperties(p);
        // display new properties
        System.getProperties().list(System.out);
    }
}
