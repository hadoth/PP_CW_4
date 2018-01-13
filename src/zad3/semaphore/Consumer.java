package zad3.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Queue<Integer> queue;
    private Semaphore addPermits;
    private Semaphore takePermits;
    private String message;

    public Consumer(Queue<Integer> queue, Semaphore addPermits, Semaphore takePermits, String message) {
        this.queue = queue;
        this.message = " " + message;
        this.addPermits = addPermits;
        this.takePermits = takePermits;
    }

    @Override
    public void run() {
        boolean run = true;
        while (run) {
            try {
                this.takePermits.acquire();
                System.out.println(this.queue.remove() + message);
                this.addPermits.release();
            } catch (InterruptedException e) {
                run = false;
            }
        }
    }
}
