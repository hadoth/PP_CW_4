package zad2.waitnotify;

import java.util.Date;

public class ARun extends MyRunnable {
    public ARun(History history, int interval) {
        super(history, interval);
    }

    @Override
    public void print() {
        synchronized (history) {
            if (history.getAs() + history.getBs() >= history.getCs() + history.getDs() || history.getAs() >= 2 * history.getBs()) {
                try {
                    history.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            history.addA();
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
