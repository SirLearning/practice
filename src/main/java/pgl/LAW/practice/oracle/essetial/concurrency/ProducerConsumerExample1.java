package pgl.LAW.practice.oracle.essetial.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class ProducerConsumerExample1 {
    public static void main(String[] args) {
        BlockingQueue<String> drop =
                new SynchronousQueue<String> ();
        (new Thread(new Producer1(drop))).start();
        (new Thread(new Consumer1(drop))).start();
    }
}
