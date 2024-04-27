package threads;

public class DeadlockSolution {
    public static void main(String[] args) {

        final String ruler = "ruler";
        final String pencil = "pencil";

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (ruler) {
                    System.out.println(Thread.currentThread().getName() + " is using ruler");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " wants to use pencil");

                    synchronized (pencil) {
                        System.out.println(Thread.currentThread().getName() + " is using pencil");
                    }
                }
            }
        });
        thread1.setName("John");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (ruler) {
                    System.out.println(Thread.currentThread().getName() + " is using ruler");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " wants to use ruler");
                    synchronized (ruler) {
                        System.out.println(Thread.currentThread().getName() + " is using ruler");
                    }
                }
            }
        });
        thread2.setName("Jerry");
        thread2.start();

    }
}
