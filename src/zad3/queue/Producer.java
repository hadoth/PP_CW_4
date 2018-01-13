package zad3.queue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private LinkedBlockingQueue<Integer> queue;
    private AtomicInteger value;

    public Producer(LinkedBlockingQueue<Integer> queue) {
        this.queue = queue;
        this.value = new AtomicInteger(0);
    }


    @Override
    public void run() {
        boolean run = true;
        while (run) {
            try {
                this.queue.put(this.value.incrementAndGet());
            } catch (InterruptedException e) {
                run = false;
            }
        }
    }
}
