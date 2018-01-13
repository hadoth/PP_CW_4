package zad3.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private Queue<Integer> queue;
    private AtomicInteger value;
    private Semaphore addPermits;
    private Semaphore takePermits;

    public Producer(Queue<Integer> queue, Semaphore addPermits, Semaphore takePermits, int start) {
        this.queue = queue;
        this.value = new AtomicInteger(start);
        this.addPermits = addPermits;
        this.takePermits = takePermits;
    }

    @Override
    public void run() {
        boolean run = true;
        while (run) {
            try {
                this.addPermits.acquire();
                this.queue.add(this.value.incrementAndGet());
                this.takePermits.release();
            } catch (InterruptedException e) {
                run = false;
            }
        }
    }
}
