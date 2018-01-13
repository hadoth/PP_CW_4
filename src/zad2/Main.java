package zad2;

//import zad2.waitnotify.Experiment;
import zad2.awaitsignal.Experiment;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Experiment experiment = new Experiment();
        experiment.run();
    }
}
