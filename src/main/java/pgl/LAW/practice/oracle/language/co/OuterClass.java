package pgl.LAW.practice.oracle.language.co;

public class OuterClass {

    String outerField = "Outer field";
    static String staticOuterField = "Static outer field";

    class InnerClass {
        void accessMembers() {
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
    }

    static class StaticNestedClass {
        void accessMembers(OuterClass outer) {
            // Compiler error: Cannot make a static reference to the non-static
            //     field outerField
            // System.out.println(outerField);
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
        }
    }

    public static void main(String[] args) {
        System.out.println("Inner class:");
        System.out.println("------------");
        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        innerObject.accessMembers();

        System.out.println("\nStatic nested class:");
        System.out.println("--------------------");
        StaticNestedClass staticNestedObject = new StaticNestedClass();
        staticNestedObject.accessMembers(outerObject);

        System.out.println("\nTop-level class:");
        System.out.println("--------------------");
        TopLevelClass topLevelObject = new TopLevelClass();
        topLevelObject.accessMembers(outerObject);
    }

    public class ShadowTest {

        public int x = 0;

        class FirstLevel {

            public int x = 1;

            void methodInFirstLevel(int x) {
                System.out.println("x = " + x);
                System.out.println("this.x = " + this.x);
                System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
            }
        }

        public void main(String... args) {
            ShadowTest st = new ShadowTest();
            ShadowTest.FirstLevel fl = st.new FirstLevel();
            fl.methodInFirstLevel(23);
        }
    }
}
