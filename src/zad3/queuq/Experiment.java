package zad3.queuq;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Experiment {
    public void run() {
        final int MAX_SIZE = 20;
        Queue<Integer> queue = new LinkedBlockingQueue<>(MAX_SIZE);
        Semaphore available = new Semaphore(MAX_SIZE-1, true);
        Semaphore taken = new Semaphore(MAX_SIZE-1, true);
        long interval = 10;
        Producer producer1 = new Producer(queue, interval, available, taken, 100);
        Producer producer2 = new Producer(queue, interval, available, taken, 200);
        Producer producer3 = new Producer(queue, interval, available, taken, 300);
        Producer producer4 = new Producer(queue, interval, available, taken, 400);
        Consumer consumer1 = new Consumer(queue, interval, available, taken, "c1");
        Consumer consumer2 = new Consumer(queue, interval, available, taken, "c2");
        Consumer consumer3 = new Consumer(queue, interval, available, taken, "c3");
        Consumer consumer4 = new Consumer(queue, interval, available, taken, "c4");

        Thread thread1 = new Thread(producer1);
        Thread thread2 = new Thread(producer2);
        Thread thread3 = new Thread(producer3);
        Thread thread4 = new Thread(producer4);
        Thread thread5 = new Thread(consumer1);
        Thread thread6 = new Thread(consumer2);
        Thread thread7 = new Thread(consumer3);
        Thread thread8 = new Thread(consumer4);
        thread1.start();
        thread5.start();
        thread2.start();
        thread6.start();
        thread3.start();
        thread7.start();
        thread4.start();
        thread8.start();
    }
}
