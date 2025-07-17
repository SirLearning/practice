package pgl.LAW.practice.oracle.language.co;

public class NestedClasses {
    class OuterClass {
        class InnerClass {}
    }

    public class InnerClass {}

    public void main(String[] args) {
        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
    }
}
