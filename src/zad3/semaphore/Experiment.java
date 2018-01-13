package zad3.semaphore;

import java.util.concurrent.LinkedBlockingQueue;

public class Experiment {
    public void run() {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(20);
        long interval = 10;
        Producer producer = new Producer(queue, interval);
        Consumer consumer = new Consumer(queue, interval);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }
}
