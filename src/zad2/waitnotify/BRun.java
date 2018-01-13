package zad2.waitnotify;

import java.util.Date;

public class BRun extends MyRunnable {
    public BRun(History history, int interval) {
        super(history, interval);
    }

    @Override
    public void print() {
        synchronized (history) {
            if (history.getAs() + history.getBs() >= history.getCs() + history.getDs()) {
                try {
                    history.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            history.addB();
            history.notify();
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
