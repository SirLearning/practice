package pgl.LAW.practice.oracle.language.generics;

import java.util.Collection;

public class RelativelyPrimePredicate implements UnaryPredicate<Integer> {

    public RelativelyPrimePredicate(Collection<Integer> c) {
        this.c = c;
    }

    public boolean test(Integer x) {
        for (Integer i : c)
            if (Algorithm3.gcd(x, i) != 1)
                return false;

        return c.size() > 0;
    }

    private Collection<Integer> c;
}
