package zad3.queuq;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Queue<Integer> queue;
    private long interval;
    private Semaphore available;
    private Semaphore taken;
    private String message;

    public Consumer(Queue<Integer> queue, long interval, Semaphore available, Semaphore taken, String message) {
        this.queue = queue;
        this.interval = interval;
        this.available = available;
        this.message = " " + message;
        this.taken = taken;
    }

    @Override
    public void run() {
        long now = new Date().getTime() + this.interval;
        while (new Date().getTime() < now) {
            try {
                this.taken.acquire();
                System.out.print(this.queue.remove());
                System.out.println(message);
                this.available.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
