package pgl.LAW.practice.oracle.language.anno;

public class MyHouse implements House {
    // The documentation is
    // inherited from the interface.
    @Deprecated
//    or @SuppressWarnings("deprecation")
    public void open() {}
    public void openFrontDoor() {}
    public void openBackDoor() {}
}
