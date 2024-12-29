package threads_02;

// In MultiThread application, if the thread needs another thread to do some work in order to continue with this task
// then, this communication between threads can be established with wait() / notify() or wait() / interrupt()
public class WaitInterrupt {


    public volatile int balance = 0;

    public synchronized void deposit (int amount) {
        System.out.println(Thread.currentThread().getName() + " wants to deposit " + amount + " dollars.");
        this.balance += amount;
        System.out.println("Deposit successful. Updated balance: " + this.balance);
    }

    public synchronized void withdraw (int amount) {
        System.out.println(Thread.currentThread().getName() + " wants to withdraw " + amount + " dollars.");

        if (balance < amount || balance == 0) {
            System.out.println("Insufficient funds. Your balance: " + this.balance + "$");
            System.out.println("Waiting for deposit");
            try {
                wait();
                // Temporarily releases the monitored obj until notify() method is called
            } catch (InterruptedException e) {
                System.out.println("Balance updated. Continuing withdrawal.");
            }
        }

        if (balance >= amount) {
            this.balance -= amount;
            System.out.println("Withdraw successful. Updated balance: " + this.balance);
        } else {
            System.out.println("Insufficient funds. Your balance is: " + this.balance + " $");
        }
    }

    public static void main(String[] args) {

        WaitNotify01 obj = new WaitNotify01();

        Thread consumerThread = new Thread(() -> {
            obj.withdraw(200);
        });
        consumerThread.setName("Consumer");
        consumerThread.start();

        Thread producerThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            obj.deposit(1500);
            consumerThread.interrupt();
//            Forcefully interrupts the waiting process of consumerThread
        });
        producerThread.setName("Producer");
        producerThread.start();
    }
}
