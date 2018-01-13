package zad2.awaitsignal;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class DRun extends MyRunnable {
    private Condition abCondition;
    private Condition cCondition;
    public DRun(History history, int interval, Lock lock, Condition abCondition, Condition cCondition) {
        super(history, interval, lock);
        this.abCondition = abCondition;
        this.cCondition = cCondition;
    }

    @Override
    public void print() throws InterruptedException {
        this.lock.lock();
        try {
            history.addD();
            this.abCondition.signalAll();
            this.cCondition.signalAll();
        } finally {
            this.lock.unlock();
        }
    }

    @Override
    public void run() {
        long now = new Date().getTime() + this.interval;
        while (new Date().getTime() < now) {
            try {
                this.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
