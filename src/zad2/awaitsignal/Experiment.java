package zad2.awaitsignal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Experiment {
    public void run() throws InterruptedException {
        History history = new History();
        final Lock lock = new ReentrantLock();
        final Condition canAB = lock.newCondition();
        final Condition canA = lock.newCondition();
        final Condition canC = lock.newCondition();
        int interval = 2;
        MyRunnable ar = new ARun(history, interval, lock, canAB, canA);
        MyRunnable br = new BRun(history, interval, lock, canAB, canA);
        MyRunnable cr = new CRun(history, interval, lock, canAB, canC);
        MyRunnable dr = new DRun(history, interval, lock, canAB, canC);
        Thread a = new Thread(ar);
        Thread b = new Thread(br);
        Thread c = new Thread(cr);
        Thread d = new Thread(dr);
        a.start();
        b.start();
        c.start();
        d.start();
        Thread.sleep(3 * interval);
        history.printHistory();
    }
}
