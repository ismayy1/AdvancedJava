package threads;

public class MultiThreading01 {
    public static void main(String[] args) {

//        long start = System.currentTimeMillis();
//        Counter counter1 = new Counter("Sedat");
//        Counter counter2 = new Counter("Tevfik");
//        counter1.count();
//        counter2.count();
//        long finish = System.currentTimeMillis();
//        System.out.println("Time duration in main thread: "+ (finish - start));

        long start = System.currentTimeMillis();

        System.out.println("=========== multi Threading ===========");
        Thread thread1 = new ThreadCounter("Mikail");
        Thread thread2 = new ThreadCounter("Tamara");
        thread1.start();
        thread2.start();

        try {
            thread1.join(); // thread (the thread which is running) will wait for thread1
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long finish = System.currentTimeMillis();
        System.out.println("Time duration in multi thread: "+ (finish - start));

    }
}

class Counter {
    public String name;
    public Counter(String name) {
        this.name = name;
    }
    // method to count from 1 to 10
    public void count() {
        for (int i=0; i<11; i++) {
            try {
                Thread.sleep(500);  // goal is to make it delay for 0.5 seconds
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + " - " + this.name);
        }
    }
}
class ThreadCounter extends Thread {
    public String name;
    public ThreadCounter(String name) {
        this.name = name;
    }
    // method to count from 1 to 10
    public void count() {
        for (int i=0; i<11; i++) {
            try {
                Thread.sleep(500);  // goal is to make it delay for 0.5 seconds
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + " - " + this.name);
        }
    }

    @Override
    public void run() {
        count();
    }
}