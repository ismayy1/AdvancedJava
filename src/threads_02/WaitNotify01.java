package threads_02;

// wait() - notify() methods allow communication between threads
public class WaitNotify01 {
    /*
        TASK: Develop an app for a student's bank deposits and withdrawals
            - If there's not enough balance in the account, student should wait.
            - When the deposit happens, student should continue with withdrawal. (notify() will be used)
     */

    public volatile int balance = 0;

    public synchronized void deposit (int amount) {
        System.out.println(Thread.currentThread().getName() + " wants to deposit " + amount + " dollars.");
        this.balance += amount;
        System.out.println("Deposit successful. Updated balance: " + this.balance);
        notify();
        // notify() doesn't release the var because of the synchronized keyword
        // This method notifies threads waiting with "wait()" method
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
                throw new RuntimeException(e);
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

        Thread sonThread = new Thread(() -> {
            obj.withdraw(200);
        });
        sonThread.setName("Bob");
        sonThread.start();

        Thread fatherThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                obj.deposit(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        fatherThread.setName("Jack");
        fatherThread.start();
    }
}
