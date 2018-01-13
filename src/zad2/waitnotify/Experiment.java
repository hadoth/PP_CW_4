package zad2.waitnotify;

public class Experiment {
    public void run() throws InterruptedException {
        History history = new History();
        int interval = 2;
        MyRunnable ar = new ARun(history, interval);
        MyRunnable br = new BRun(history, interval);
        MyRunnable cr = new CRun(history, interval);
        MyRunnable dr = new DRun(history, interval);
        Thread a = new Thread(ar);
        Thread b = new Thread(br);
        Thread c = new Thread(cr);
        Thread d = new Thread(dr);
        a.start();
        b.start();
        c.start();
        d.start();
        Thread.sleep(2 * interval);
        history.printHistory();
    }
}
