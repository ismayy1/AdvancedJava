package threads;

// Task: print [ [ [ [ [] ] ] ] ] brackets in 14 lines
// use two thread
public class SynchronizedBlock {
    public static void main(String[] args) {

        Brackets brackets = new Brackets();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1; i<=7; i++) {
                    brackets.printBrackets();
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1; i<=7; i++) {
                    brackets.printBrackets();
                }
            }
        });

        long start = System.currentTimeMillis();

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // main thread must wait to finish
            thread2.join(); // main thread must wait to finish
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        System.out.println("Time spent: " + (end - start));

        // synchronized method: 30290
        // synchronized method: 15324

    }
}

class Brackets {
    public /*synchronized*/ void printBrackets() {
        synchronized (this) {
            for (int i = 1; i <= 10; i++) {
                if (i < 6) {
                    System.out.print("[ ");
                } else {
                    System.out.print(" ]");
                }
            }
        }
        System.out.println("===> " + Thread.currentThread().getName());

        // tasks which can be done asynchronously
        for (int i=1; i<8; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            System.out.println("Washing hands");
        }
    }
}
