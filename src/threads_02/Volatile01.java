package threads_02;

public class Volatile01 {

    public static volatile int flag = 0;
    // with 'volatile' keyword, we tell our computer to NOT cache the var in CPU. Thus, we prevent StackOverFlow.

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            while (flag == 0) {
                System.out.println("This is a risk!");
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                flag = 1;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();
    }
}
