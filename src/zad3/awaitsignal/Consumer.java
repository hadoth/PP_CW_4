package zad3.awaitsignal;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable {
    private final Queue<Integer> queue;
    private String message;
    private Lock lock;
    private Condition empty;
    private Condition full;

    public Consumer(Queue<Integer> queue, String message, Lock lock, Condition empty, Condition full) {
        this.queue = queue;
        this.message = " " + message;
        this.lock = lock;
        this.empty = empty;
        this.full = full;
    }

    @Override
    public void run() {
        while (true) {
            this.lock.lock();
            try {
                while (this.queue.size() <= 0) {
                    empty.await();
                }
                System.out.println(this.queue.remove() + message);
                this.full.signalAll();
            } catch (InterruptedException e) {
                break;
            } finally {
                this.lock.unlock();
            }
        }
    }
}
