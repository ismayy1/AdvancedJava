package threads_02;

public class MultiThreading01 {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

//        TASK: We'll count from 1 to 15 twice.
//          First: we'll not use threads, and see how long it takes
//          Then: we'll use threads and compare the times: Main Thread

        /*
        Counter counter1 = new Counter("Bob");
        Counter counter2 = new Counter("Mike");

        counter1.count();
        counter2.count();

        long finishTime = System.currentTimeMillis();
        System.out.println("Main thread counted in: " + (finishTime - startTime) + " ms!");
         */

//        TASK: We'll count from 1 to 15 twice.
//          First: we'll not use threads, and see how long it takes
//          Then: we'll use threads and compare the times: Multi-Threading

        long startTime2 = System.currentTimeMillis();
        System.out.println("================== Multi-Threading =================");

        Thread thread1 = new CounterThread("John");
        Thread thread2 = new CounterThread("Jack");
        Thread thread3 = new CounterThread("Daniel");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join(); // tells the main thread to wait until this thread is finish executing
            thread2.join(); // tells the main thread to wait until this thread is finish executing
            thread3.join(); // tells the main thread to wait until this thread is finish executing
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long finishTime2 = System.currentTimeMillis();
        System.out.println("MultiThreading thread counted in: " + (finishTime2 - startTime2) + " ms!");

    }
}

class Counter {

    public String name;

    public Counter(String name) {
        this.name = name;
    }

    public void count() {
        for (int i = 0; i < 16; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + " Counter Name: " + this.name);
        }
    }
}

class CounterThread extends Thread {

    public String name;

    public CounterThread(String name) {
        this.name = name;
    }

    public void count() {
        for (int i = 0; i < 16; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + " Counter Name: " + this.name);
        }
    }
    @Override
    public void run() {
        count();
    }
}