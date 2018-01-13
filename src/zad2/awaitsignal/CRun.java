package zad2.awaitsignal;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class CRun extends MyRunnable {
    private Condition abCondition;
    private Condition cCondition;
    public CRun(History history, int interval, Lock lock, Condition abCondition, Condition cCondition) {
        super(history, interval, lock);
        this.abCondition = abCondition;
        this.cCondition = cCondition;
    }

    @Override
    public void print() {
        this.lock.lock();
        try {
            while (!history.canC()) {
                this.cCondition.await();
            }
            history.addC();
            this.abCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.lock.unlock();
        }
    }

    @Override
    public void run() {
        long now = new Date().getTime() + this.interval;
        while (new Date().getTime() < now) {
            this.print();
        }
    }
}
