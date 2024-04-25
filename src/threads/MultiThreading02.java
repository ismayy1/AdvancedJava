package threads;

public class MultiThreading02 {

    public volatile static int counterBoard = 0;
    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i=0; i<10; i++) {
                    System.out.println("Tamara is doing some other task");
                }

                // task to sell ticket ~
                MyCounter.count();
            }
        });

        thread1.setName("Tamara");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                // this task will be completed asynchronously
                for(int i=0; i<10; i++) {
                    System.out.println("Some other task than 'task to sell ticket' task");
                }

                MyCounter.count();

                for (int i=0; i<10; i++) {
                    System.out.println("Sedat is doing some personal task");
                }

            }
        });

        thread2.setName("Sedat");
        thread2.start();

    }
}

class MyCounter {
    //synchronized keyword blocks the method count for one thread at a time ....
    public static synchronized void count() {
        for (int i=1; i<=1000; i++) {
            MultiThreading02.counterBoard++;    // 1st read value from counterBoard, 2nd increment current, 3rd update
            System.out.println(Thread.currentThread().getName() + "===> counter: " + MultiThreading02.counterBoard);
        }
    }
}
