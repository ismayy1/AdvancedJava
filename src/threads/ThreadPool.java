package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {

        int availableProcessor = Runtime.getRuntime().availableProcessors();
        System.out.println("Available Processors: " + availableProcessor);

        ExecutorService service = Executors.newFixedThreadPool(4);

        ThreadCreator thread1 = new ThreadCreator("Thread1");
        ThreadCreator thread2 = new ThreadCreator("Thread2");
        ThreadCreator thread3 = new ThreadCreator("Thread3");
        ThreadCreator thread4 = new ThreadCreator("Thread4");
        ThreadCreator thread5 = new ThreadCreator("Thread5");
        ThreadCreator thread6 = new ThreadCreator("Thread6");
        ThreadCreator thread7 = new ThreadCreator("Thread7");
        ThreadCreator thread8 = new ThreadCreator("Thread8");
        ThreadCreator thread9 = new ThreadCreator("Thread9");
        ThreadCreator thread10 = new ThreadCreator("Thread10");
        ThreadCreator thread11 = new ThreadCreator("Thread11");

        //normal way of starting threads
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//        thread6.start();
//        thread7.start();
//        thread8.start();
//        thread9.start();
//        thread10.start();
//        thread11.start();

        service.execute(thread1);
        service.execute(thread2);
        service.execute(thread3);
        service.execute(thread4);
        service.execute(thread5);
        service.execute(thread6);
        service.execute(thread7);
        service.execute(thread8);
        service.execute(thread9);
        service.execute(thread10);
        service.execute(thread11);

        // to shut down the Executor service after the tasks are finished executing
        service.shutdown();

    }
}

class ThreadCreator extends Thread {

    private String name;

    public ThreadCreator(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " Thread started the task...");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(name + " Thread completed the task...");
    }
}
