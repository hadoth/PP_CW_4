package zad1.banksystemsynchronized;

public class Account {
    private int balance;

    public Account() {
        this.balance = 100;
    }

    public int transferIn(int value) {
        this.balance += value;
        return this.balance;
    }

    public int transferOut(int value) {
        this.balance -= value;
        return this.balance;
    }

    public int getBalance() {
        return balance;
    }
}
