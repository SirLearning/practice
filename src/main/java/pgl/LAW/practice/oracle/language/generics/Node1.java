package pgl.LAW.practice.oracle.language.generics;

public class Node1<T> {

    private T data;
    private Node1<T> next;

    public Node1(T data, Node1<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() { return data; }
    // ...
}
