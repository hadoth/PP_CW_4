package zad2.waitnotify;

import java.util.Date;

public class CRun extends MyRunnable {
    public CRun(History history, int interval) {
        super(history, interval);
    }

    @Override
    public void print() {
        synchronized (history) {

            if (!history.canC()) {
                try {
                    history.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            history.addC();
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
