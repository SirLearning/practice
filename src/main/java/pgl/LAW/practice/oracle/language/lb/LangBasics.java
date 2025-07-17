package pgl.LAW.practice.oracle.language.lb;

public class LangBasics {

    class BreakWithLabel {
        public void main(String[] args) {
            int[][] arrayOfInts = {
                    {32, 87, 3, 589},
                    {12, 1076, 2000, 8},
                    {622, 127, 77, 955}
            };
            int searchFor = 12;
            int i;
            int j = 0;
            boolean foundIt = false;
            search:
            for (i = 0; i < arrayOfInts.length; i++) {
                for (j = 0; j < arrayOfInts[i].length; j++) {
                    if (arrayOfInts[i][j] == searchFor) {
                        foundIt = true;
                        break search;
                    }
                }
            }
            if (foundIt) {
                System.out.println("found" + searchFor + " at" + i + ", " + j);
            } else System.out.println(searchFor + " not in the array");
        }
    }

    class ContinueWithLabelDemo {
        public void main(String[] args) {

            String searchMe = "Look for a substring in me";
            String substring = "sub";
            boolean foundIt = false;

            int max = searchMe.length() -
                    substring.length();

            test:
            for (int i = 0; i <= max; i++) {
                int n = substring.length();
                int j = i;
                int k = 0;
                while (n-- != 0) {
                    if (searchMe.charAt(j++) != substring.charAt(k++)) {
                        continue test;
                    }
                }
                foundIt = true;
                break test;
            }
            System.out.println(foundIt ? "Found it" : "Didn't find it");
        }
    }
}

