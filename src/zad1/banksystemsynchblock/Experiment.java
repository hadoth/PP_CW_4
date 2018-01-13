package zad1.banksystemsynchblock;

import java.util.ArrayList;
import java.util.List;

public class Experiment {
    private List<Thread> threads = new ArrayList<>();
    private Bank bank;

    public Experiment(int userCount, int transferCount, int accountCount) {
        this.bank = new Bank(accountCount);
        for (int userId = 0; userId < userCount; userId++) {
            threads.add(new Thread(new BankUser(bank, transferCount)));
        }
    }

    public int getBalance() {
        return this.bank.getBalance();
    }

    public void run() {
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
