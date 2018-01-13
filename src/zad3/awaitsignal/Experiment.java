package zad3.awaitsignal;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Experiment extends Thread {
    public void run() {
        final int MAX_SIZE = 20;
        final long INTERVAL = 10;
        final int AGENT_COUNT = 5;

        Queue<Integer> queue = new LinkedBlockingQueue<>(MAX_SIZE);
        Lock lock = new ReentrantLock();
        Condition full = lock.newCondition();
        Condition empty = lock.newCondition();

        List<Producer> producers  = new ArrayList<>();
        List<Consumer> consumers = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int agentIndex = 0; agentIndex < AGENT_COUNT; agentIndex++) {
            producers.add(new Producer(queue, (agentIndex + 1) * 1000000, MAX_SIZE, lock, empty, full));
            consumers.add(new Consumer(queue, "c" + (agentIndex + 1), lock, empty, full));
            threads.add(new Thread(producers.get(agentIndex)));
            threads.add(new Thread(consumers.get(agentIndex)));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            sleep(INTERVAL);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            for (Thread thread : threads) {
                thread.interrupt();
            }
        }
    }
}
