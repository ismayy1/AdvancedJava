package threads_02;

// There are 2 ways to create a Thread:
//  1. A class that will extend from the Thread class
//  2. Creating a thread by implementing the Runnable interface
public class ThreadCreationWays {
    public static void main(String[] args) {

//        All Java Programs have a thread started bt default: the main thread
//        Threads work asynchronously but the codes in the run() work synchronously
        System.out.println("Current Thread: " + Thread.currentThread().getName());

        Thread thread1 = new MyThread();
        thread1.start();
        thread1.setName("Bob");
//        thread1.run();    // Won't create a thread, it'll just call a run method from the main thread

        Runnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();

//        Second approach
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Working Thread: " + Thread.currentThread().getName());
                System.out.println("Thread created with an ANONYMOUS class started!");
                System.out.println("Anonymous thread is sleeping now");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Anonymous thread woke up");
            }
        });
        thread3.start();

//        Third approach
        Thread thread4 = new Thread(() -> {
//            Here's the body of the run()
            System.out.println("Working Thread: " + Thread.currentThread().getName());
            System.out.println("Thread created with a LAMBDA expression started!");
        });
        thread4.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main Method Execution Completed");
    }
}

//  FIRST WAY
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Working Thread: " + Thread.currentThread().getName());
    }
}

//  SECOND WAY
class MyRunnable implements Runnable {
//    Runnable -> is an interface that has only 1 method to implement,  teh run().
//    If an interface has only 1 method to implement, that interface is called a "Functional Interface"

    @Override
    public void run() {
        System.out.println("Working Thread: " + Thread.currentThread().getName());
        System.out.println("Thread created with a 'Runnable' started!");
    }
}