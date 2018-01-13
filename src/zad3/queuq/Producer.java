package zad3.queuq;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private Queue<Integer> queue;
    private AtomicInteger value;
    private long interval;
    private Semaphore available;
    private Semaphore taken;

    public Producer(Queue<Integer> queue, long interval, Semaphore available, Semaphore taken, int start) {
        this.queue = queue;
        this.value = new AtomicInteger(start);
        this.interval = interval;
        this.available = available;
        this.taken = taken;
    }

    @Override
    public void run() {
        long now = new Date().getTime() + (this.interval * 2);
        while (new Date().getTime() < now) {
            try {
                this.available.acquire();
                this.queue.add(this.value.incrementAndGet());
                this.taken.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
