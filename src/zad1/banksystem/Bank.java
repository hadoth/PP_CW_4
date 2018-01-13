package zad1.banksystem;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public Bank() {
        this(100);
    }

    public Bank(int accountNumber) {
        for (int accountId = 0; accountId < accountNumber; accountId++) {
            this.accounts.add(new Account());
        }
    }

    public int getBalance() {
        int balance = 0;
        for (Account account : accounts) {
            balance += account.getBalance();
        }
        return balance;
    }

    public int getAccountsCount() {
        return this.accounts.size();
    }

    public void transferMoney(int fromAccountId, int toAccountId, int amount) {
        if (fromAccountId >= this.accounts.size() || fromAccountId < 0) {
            throw new IllegalArgumentException("Invalid account ID" + fromAccountId);
        }
        if (toAccountId >= this.accounts.size() || toAccountId < 0) {
            throw new IllegalArgumentException("Invalid account ID" + toAccountId);
        }
        this.accounts.get(fromAccountId).transferOut(amount);
        this.accounts.get(toAccountId).transferIn(amount);
    }
}
