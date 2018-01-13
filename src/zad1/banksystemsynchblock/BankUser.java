package zad1.banksystemsynchblock;

public class BankUser implements Runnable {
    private Bank bank;
    private int operationCount;

    public BankUser(Bank bank) {
        this(bank, 100);
    }

    public BankUser(Bank bank, int operationCount) {
        this.bank = bank;
        this.operationCount = operationCount;
    }

    private int getRandomAccountId() {
        return (int)(Math.random() * this.bank.getAccountsCount());
    }

    private void makeTransfer() {
        this.bank.transferMoney(getRandomAccountId(), getRandomAccountId(), 1);
    }

    @Override
    public void run() {
        for (int operationIndex = 0; operationIndex < operationCount; operationIndex++) {
            this.makeTransfer();
        }
    }
}
