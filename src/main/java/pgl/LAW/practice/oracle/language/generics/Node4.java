package pgl.LAW.practice.oracle.language.generics;

public class Node4 {

    private Comparable data;
    private Node4 next;

    public Node4(Comparable data, Node4 next) {
        this.data = data;
        this.next = next;
    }

    public Comparable getData() { return data; }
    // ...
}
