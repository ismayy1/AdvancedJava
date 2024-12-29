package threads_02;

import java.util.concurrent.CountDownLatch;

        /*
            We can make a thread wait before multiple threads (worker threads) to be done with their work.
            And then continue the process using a CountDownLatch
         */

public class CountDownLatch01 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started working.");
            System.out.println(Thread.currentThread().getName() + " continuing the work.");
            System.out.println(Thread.currentThread().getName() + " finished working.");
        });
        thread1.start();
    }
}

class WorkerThreads extends Thread {
    public int duration;
    public CountDownLatch latch;

    public WorkerThreads(String name, int duration, CountDownLatch latch) {
        super(name);
        this.duration = duration;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started working.");
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " finished working.");
    }
}