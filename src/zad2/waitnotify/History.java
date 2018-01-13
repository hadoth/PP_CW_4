package zad2.waitnotify;

import java.util.concurrent.ConcurrentLinkedDeque;

public class History {
    private int as;
    private int bs;
    private int cs;
    private int ds;
    private ConcurrentLinkedDeque<String> buffer;
    private boolean canC;

    public History() {
        as = 0;
        bs = 0;
        cs = 0;
        ds = 0;
        canC = true;
        buffer = new ConcurrentLinkedDeque<>();
    }

    public void addA() {
        as++;
        buffer.add("A" + " " + as + " " + bs + " " + cs + " " + ds + " " + (as+bs+cs+ds));
    }

    public void addB() {
        bs++;
        buffer.add("B" + " " + as + " " + bs + " " + cs + " " + ds + " " + (as+bs+cs+ds));
    }

    public void addC() {
        cs++;
        canC = false;
        buffer.add("C" + " " + as + " " + bs + " " + cs + " " + ds + " " + (as+bs+cs+ds));
    }

    public void addD() {
        ds++;
        canC = true;
        buffer.add("D" + " " + as + " " + bs + " " + cs + " " + ds + " " + (as+bs+cs+ds));
    }

    public int getAs() {
        return as;
    }

    public int getBs() {
        return bs;
    }

    public int getCs() {
        return cs;
    }

    public int getDs() {
        return ds;
    }

    public boolean canC() {
        return this.canC;
    }

    public int getTotal() {
        return this.as + this.bs + this.cs + this.ds;
    }

    public void printHistory() {
        int index = 1;
        while (!buffer.isEmpty()) {
            System.out.println(buffer.pop() + " " + index++);
        }
    }
}
