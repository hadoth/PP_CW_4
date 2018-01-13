package zad2.awaitsignal;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class BRun extends MyRunnable {
    private Condition abCondition;
    private Condition aCondition;
    public BRun(History history, int interval, Lock lock, Condition abCondition, Condition aCondition) {
        super(history, interval, lock);
        this.abCondition = abCondition;
        this.aCondition = aCondition;
    }

    @Override
    public void print() {
        this.lock.lock();
        try {
            while (history.getAs() + history.getBs() >= history.getCs() + history.getDs()) {
                this.abCondition.await();
            }
            history.addB();
            this.aCondition.signalAll();
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
