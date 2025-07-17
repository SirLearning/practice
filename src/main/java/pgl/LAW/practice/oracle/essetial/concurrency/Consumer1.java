package pgl.LAW.practice.oracle.essetial.concurrency;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer1 implements Runnable {
    private BlockingQueue<String> drop;

    public Consumer1(BlockingQueue<String> drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();
        try {
            for (String message = drop.take();
                 ! message.equals("DONE");
                 message = drop.take()) {
                System.out.format("MESSAGE RECEIVED: %s%n",
                        message);
                Thread.sleep(random.nextInt(5000));
            }
        } catch (InterruptedException e) {}
    }
}
