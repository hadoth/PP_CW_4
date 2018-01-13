package zad2.awaitsignal;

import java.util.concurrent.locks.Lock;

public abstract class MyRunnable implements Runnable {
    protected final History history;
    protected int interval;
    protected Lock lock;

    public MyRunnable(History history, int interval, Lock lock) {
        this.history = history;
        this.interval = interval;
        this.lock = lock;
    }

    public abstract void print() throws InterruptedException;
}
