package pgl.LAW.practice.oracle.language.anno;

public interface House {
    /**
     * @deprecated use of open
     * is discouraged, use
     * openFrontDoor or
     * openBackDoor instead.
     */
    @Deprecated
    public void open();
    public void openFrontDoor();
    public void openBackDoor();
}
