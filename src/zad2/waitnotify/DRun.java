package zad2.waitnotify;

import java.util.Date;

public class DRun extends MyRunnable {
    public DRun(History history, int interval) {
        super(history, interval);
    }

    @Override
    public void print() throws InterruptedException {
        synchronized (history) {
            history.addD();
            history.notify();
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
