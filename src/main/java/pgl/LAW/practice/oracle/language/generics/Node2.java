package pgl.LAW.practice.oracle.language.generics;

public class Node2 {
    private Object data;
    private Node2 next;

    public Node2(Object data, Node2 next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() { return data; }
    // ...
}
