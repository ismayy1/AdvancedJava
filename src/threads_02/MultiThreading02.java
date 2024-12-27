package threads_02;

public class MultiThreading02 {

    public static int counter = 0;

    public static void main(String[] args) {

        Thread bobThread = new Thread(() -> {
            NewCounter.count();
            System.out.println("Bob sold Lemonade!");
            System.out.println("Bob sold Lemonade!");
            System.out.println("Bob sold Lemonade!");
            System.out.println("Bob sold Lemonade!");
            System.out.println("Bob sold Lemonade!");
            System.out.println("Bob sold Lemonade!");
            System.out.println("Bob sold Lemonade!");
            System.out.println("Bob sold Lemonade!");
            System.out.println("Bob sold Lemonade!");
        });
        bobThread.setName("Bob");
        bobThread.start();

        Thread mikeThread = new Thread(() -> {
            NewCounter.count();
            System.out.println("Mike sold IceCream.");
            System.out.println("Mike sold IceCream.");
            System.out.println("Mike sold IceCream.");
            System.out.println("Mike sold IceCream.");
            System.out.println("Mike sold IceCream.");
            System.out.println("Mike sold IceCream.");
            System.out.println("Mike sold IceCream.");
            System.out.println("Mike sold IceCream.");
            System.out.println("Mike sold IceCream.");
        });
        mikeThread.setName("Mike");
        mikeThread.start();
    }
}

class NewCounter {
    public static synchronized void count() {
        for (int i = 1; i <= 1000; i++) {
            MultiThreading02.counter++;
        }
        System.out.println("==========> Counter: " + MultiThreading02.counter);
    }
}
