package zad2.waitnotify;

import java.util.ArrayList;
import java.util.List;

public abstract class MyRunnable implements Runnable {
    protected final History history;
    protected int interval;
    private List<Object> locks;

    public MyRunnable(History history, int interval) {
        this.history = history;
        this.interval = interval;
        this.locks = new ArrayList<>();
    }

    public abstract void print() throws InterruptedException;
}
