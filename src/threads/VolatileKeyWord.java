package threads;

public class VolatileKeyWord {

    private volatile static int counter = 0;
    public static void main(String[] args) {

        // reading the value of counter
        Thread thread1 = new Thread(() -> {
            int localCounter = counter;

            while (localCounter < 10) {
                if (localCounter != counter) {
                    System.out.println("Thread1 localCounter is changed");
                    localCounter = counter;
                }
            }
        });


        Thread thread2 = new Thread(() -> {
            int localCounter = counter;

            while (localCounter < 10) {
                System.out.println("Thread2 incremented counter to: " + (localCounter+1));
                counter = ++localCounter;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}
