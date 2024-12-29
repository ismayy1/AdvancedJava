package threads_02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(3);

        Thread courier1 = new ThreadCreator("a", 3000);
        Thread courier2 = new ThreadCreator("b", 8000);
        Thread courier3 = new ThreadCreator("c", 5000);
        Thread courier4 = new ThreadCreator("d", 7000);
        Thread courier5 = new ThreadCreator("e", 1000);
        Thread courier6 = new ThreadCreator("f", 11000);
        Thread courier7 = new ThreadCreator("g", 9700);
        Thread courier8 = new ThreadCreator("h", 4000);
        /*
        courier1.start();
        courier2.start();
        courier3.start();
        courier4.start();
        courier5.start();
        courier6.start();
        courier7.start();
        courier8.start();
         */

        service.execute(courier1);
        service.execute(courier2);
        service.execute(courier3);
        service.execute(courier4);
        service.execute(courier5);
        service.execute(courier6);
        service.execute(courier7);
        service.execute(courier8);

        service.shutdown();
    }
}

class ThreadCreator extends Thread {

    public String task;
    public int duration;

    public ThreadCreator(String task, int duration) {
        this.task = task;
        this.duration = duration;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started working. The task: " + this.task);
        System.out.println();

        try {
            Thread.sleep(duration); // Out threads will finish their work in different durations
            System.out.println(Thread.currentThread().getName() + " finished their work.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}