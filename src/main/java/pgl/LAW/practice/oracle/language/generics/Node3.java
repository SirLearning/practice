package pgl.LAW.practice.oracle.language.generics;

public class Node3<T extends Comparable<T>> {

    private T data;
    private Node3<T> next;

    public Node3(T data, Node3<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() { return data; }
    // ...
}
