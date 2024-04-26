package threads;

public class WaitInterrupt {

    public static int balance = 0;
    //method to deposit some amount
    public synchronized void deposit (int amount){
        System.out.println(Thread.currentThread().getName()+" wants to deposit money..");
        this.balance += amount;
        System.out.println("Money transferred successfully. Current amount: "+this.balance);

    }

    //method to withdraw money
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" wants to withdraw money");
        if(balance == 0 || balance < amount){
            System.out.println("Insufficient amount. Current amount: "+this.balance);
            System.out.println("Waiting for the balance update");
        }

        try {
            wait(); //wait() sets free the monitoring thread temporarly until it gets notified

        } catch (InterruptedException e) {
            System.out.println("Balance is updated.......");
        }
        //once waiting thread gets notification, it will start from where it left of

        if(balance > amount){
            this.balance -= amount;
            System.out.println("Money is withdrawn successfully. Current balance: "+this.balance);
        }
    }
    public static void main(String[] args) {

        WaitInterrupt obj = new WaitInterrupt();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(1000);
            }
        });
        thread1.setName("Consumer");
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
                thread1.interrupt(); //interruptin thread1 to stop
            }
        });

        thread2.setName("Producer");
        thread2.start();
    }
}
