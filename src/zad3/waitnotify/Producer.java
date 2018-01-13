package zad3.waitnotify;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private final Queue<Integer> queue;
    private AtomicInteger value;
    private int maxSize;

    public Producer(Queue<Integer> queue, int start, int maxSize) {
        this.queue = queue;
        this.value = new AtomicInteger(start);
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        rupLoop: while (true) {
            synchronized (this.queue) {
                while (this.queue.size() >= maxSize) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        break rupLoop;
                    }
                }
                this.queue.add(this.value.incrementAndGet());
                queue.notifyAll();
            }
        }
    }
}
