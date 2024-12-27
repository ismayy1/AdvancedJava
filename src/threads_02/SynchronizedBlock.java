package threads_02;

public class SynchronizedBlock {
    public static void main(String[] args) {
    //    TASK: Print '[[[[[]]]]]' on 14 lines. Accomplish this task with 2 threads, each thread printin 7 lines

        Brackets brackets = new Brackets();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 8; i++) {
                    brackets.printBrackets();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 8; i++) {
                    brackets.printBrackets();
                }
            }
        });

        long startTime = System.currentTimeMillis();
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long finishTime = System.currentTimeMillis();
        System.out.println("Time it took to finish taks: " + (finishTime - startTime) + " ms.");
    }
}

class Brackets {
    //NOTE: Since this method prints a pattern, and that pattern needs to match our
    // expectations, we need to synchronize this method. At any given time, only 1 thread
    // should be able to access this method
    public /*synchronized*/ void printBrackets() {
        // We synchronize just a part of our code if our methods also contain some code
        // that doesn't need to be synchronized
        synchronized (this) {
            for (int i = 1; i < 11; i++) {
                if (i < 6) {
                    System.out.print("[");
                } else {
                    System.out.print("]");
                }
            }
            System.out.println("=======> " + Thread.currentThread().getName());
//            Synchronized method: 156 ms, Synchronized block: 85 ms.
        }

        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(1);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
