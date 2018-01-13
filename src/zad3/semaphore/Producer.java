package zad3.semaphore;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private LinkedBlockingQueue<Integer> queue;
    private AtomicInteger value;
    private long interval;

    public Producer(LinkedBlockingQueue<Integer> queue, long interval) {
        this.queue = queue;
        this.value = new AtomicInteger(0);
        this.interval = interval;
    }

    @Override
    public void run() {
        long now = new Date().getTime() + this.interval;
        while (new Date().getTime() < now) {
            try {
                this.queue.put(this.value.incrementAndGet());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
