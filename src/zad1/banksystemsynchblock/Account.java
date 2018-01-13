package zad1.banksystemsynchblock;

public class Account {
    private int balance;

    public Account() {
        this.balance = 100;
    }

    public synchronized int transferIn(int value) {
        this.balance += value;
        return this.balance;
    }

    public synchronized int transferOut(int value) {
        this.balance -= value;
        return this.balance;
    }

    public int getBalance() {
        return balance;
    }
}
