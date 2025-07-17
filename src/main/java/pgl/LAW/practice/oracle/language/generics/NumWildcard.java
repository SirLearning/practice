package pgl.LAW.practice.oracle.language.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumWildcard {

    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    public static void main(String[] args) {
        // Integer objects
        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li));

        // Double objects
        List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println("sum = " + sumOfList(ld));

        // bound & subtyping
        List<? extends Integer> intList = new ArrayList<>();
        List<? extends Number>  numList = intList;  // OK. List<? extends Integer> is a subtype of List<? extends Number>
    }
}
