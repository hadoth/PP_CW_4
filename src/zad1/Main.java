package zad1;
import zad1.banksystem.Experiment;
//import zad1.banksystemsynchblock.Experiment;
//import zad1.banksystemsynchronized.Experiment;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int userCount = 10;
        int transferCount = 10000;
        int accountCount = 100;

        Experiment experiment = new Experiment(userCount, transferCount, accountCount);

        System.out.println("AccountBalance: " + experiment.getBalance());
        experiment.run();
        Thread.sleep(transferCount/5);
        System.out.println("AccountBalance: " + experiment.getBalance());
    }
}
