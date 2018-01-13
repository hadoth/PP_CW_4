package zad3.awaitsignal;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {
    private final Queue<Integer> queue;
    private AtomicInteger value;
    private int maxSize;
    private Lock lock;
    private Condition empty;
    private Condition full;

    public Producer(Queue<Integer> queue, int start, int maxSize, Lock lock, Condition empty, Condition full) {
        this.queue = queue;
        this.value = new AtomicInteger(start);
        this.maxSize = maxSize;
        this.lock = lock;
        this.empty = empty;
        this.full = full;
    }

    @Override
    public void run() {
        while (true) {
            this.lock.lock();
            try {
                while (this.queue.size() >= maxSize) {
                    full.await();
                }
                this.queue.add(this.value.incrementAndGet());
                this.empty.signalAll();
            } catch (InterruptedException e) {
                break;
            } finally {
                this.lock.unlock();
            }
        }
    }
}
