package threads;

import java.sql.SQLOutput;

public class WaysToCreateThread {
    public static void main(String[] args) {

        //in every app, there must be one main thread
        System.out.println("The current main thread: " + Thread.currentThread().getName());

        // 1st way to start Thread
        Thread thread1 = new MyThread();
//        thread1.run();    // this will not start new thread, just executes run method
        thread1.start();    // to start a new thread, we have to call start()
        thread1.setName("My thread 1"); // set name for thread

        System.out.println("==================== new thread =====================");
        //2nd way to start thread
        Runnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        thread2.setName("My runnable thread 2");

        System.out.println("==================== new thread =====================");
        // 2nd anonymous way to create/start thread
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println();
                System.out.println("Our custom thread 2, " + Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName() + " started");
                System.out.println("My custom anonymous thread from Runnable is being executed!!");

                System.out.println("---waits for 5 seconds");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("==================== anonymous thread waited for 5 seconds =====================");
            }
        });
        thread3.setName("My anonymous Thread 3");
        thread3.start();

        System.out.println("==================== new thread =====================");
        // 2nd anonymous simpler way with lambda to create/start thread
        Thread thread4 = new Thread(() -> {
            System.out.println("Our custom thread 2, " + Thread.currentThread().getName());
            System.out.println("My custom anonymous thread from Runnable is being executed!!");
        });
        thread4.setName("My anonymous lambda Thread 4");
        thread4.start();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("==================== main thread waited for 3 seconds =====================");


    }
}
// There are two main to create a new thread
// 1 way.
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Our custom thread 1, " + Thread.currentThread().getName());
        System.out.println("My custom thread is being executed!!");
    }
}

// 2nd way - implement Runnable (functional) interface
class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Our custom thread 2, " + Thread.currentThread().getName());
        System.out.println("My custom thread implemented from Runnable is being executed!!");
    }
}
