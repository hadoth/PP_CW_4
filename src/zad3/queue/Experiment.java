package zad3.queue;

import java.util.concurrent.LinkedBlockingQueue;

public class Experiment extends Thread {
    public void run() {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(20);
        long interval = 10;
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
        try {
            sleep(interval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            thread1.interrupt();
            thread2.interrupt();
        }
    }
}
