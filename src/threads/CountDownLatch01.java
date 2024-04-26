package threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch01 {
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(4);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Test 1 team started");
            }
        });
        thread1.setName("Test1");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Test 1 team started");
            }
        });
        thread2.setName("Test2");
        thread2.start();

        AssignTaskThread dev1 = new AssignTaskThread("Dev Team1", 2000, latch);
        AssignTaskThread dev2 = new AssignTaskThread("Dev Team2", 3000, latch);
        AssignTaskThread dev3 = new AssignTaskThread("Dev Team3", 5000, latch);
        AssignTaskThread dev4 = new AssignTaskThread("Dev Team4", 4000, latch);

        dev1.start();
        dev2.start();
        dev3.start();
        dev4.start();

        try {
            latch.await(); // causes current thread to wait until the latch counts down to zero
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " has finished");
        System.out.println("App is ready to be released");


    }
}

class AssignTaskThread extends Thread {

    private int delay;
    private CountDownLatch latch;

    // constructor
    public AssignTaskThread(String name, int delay, CountDownLatch latch) {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName() + " started");
            Thread.sleep(delay);
            System.out.println(Thread.currentThread().getName() + " finished");
            latch.countDown(); // latch counts to zero starting from the latch number

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
