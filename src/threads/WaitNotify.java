package threads;

public class WaitNotify {

    public static int balance = 0;

    //method to deposit some amount
    public synchronized void deposit (int amount) {
        System.out.println(Thread.currentThread().getName() + " wants to deposit some money!");
        this.balance += amount;
        System.out.println("Money transferred successfully. Current amount: " + this.balance);

        notify();   // sends notification to waiting threads
    }

    //method to withdraw money
    public synchronized void withdraw (int amount) {
        System.out.println(Thread.currentThread().getName() + " wants to withdraw some money!");
        if (this.balance == 0 || this.balance < amount) {
            System.out.println("Insufficient amount. Current amount: " + this.balance);
            System.out.println("Waiting for the balance to be updated!");
        }

        try {
            wait(); // sets free the monitoring thread temporarily until it gets notified
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (this.balance > amount) {
            this.balance -= amount;
            System.out.println("Money withdrawn successfully. Current balance: " + this.balance);
        }
    }

    public static void main(String[] args) {
        WaitNotify obj = new WaitNotify();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(1000);
            }
        });
        thread1.setName("Son, Withdraw");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(2000);
            }
        });
        thread2.setName("Parent, Deposit");
        thread2.start();
    }

}
