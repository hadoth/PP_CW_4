package zad3.waitnotify;

import java.util.Queue;

public class Consumer implements Runnable {
    private final Queue<Integer> queue;
    private String message;


    public Consumer(Queue<Integer> queue, String message) {
        this.queue = queue;
        this.message = " " + message;
    }

    @Override
    public void run() {
        rupLoop: while (true) {
            synchronized (this.queue) {
                while (this.queue.size() <= 0) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        break rupLoop;
                    }
                }
                System.out.println(this.queue.remove() + message);
                queue.notifyAll();
            }
        }
    }
}
