package zad3.queue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements Runnable {
    private LinkedBlockingQueue<Integer> queue;


    public Consumer(LinkedBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        boolean run = true;
        while (run) {
            try {
                System.out.println(this.queue.take());
            } catch (InterruptedException e) {
                run = false;
            }
        }
    }
}
