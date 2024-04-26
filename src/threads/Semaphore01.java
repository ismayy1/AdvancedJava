package threads;

import java.util.concurrent.Semaphore;

public class Semaphore01 {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(4);

        Car car1 = new Car("Audi", 9000, semaphore);
        Car car2 = new Car("Toyota", 7000, semaphore);
        Car car3 = new Car("Hyundai", 3000, semaphore);
        Car car4 = new Car("Tesla", 4000, semaphore);
        Car car5 = new Car("BMW", 2000, semaphore);
        Car car6 = new Car("Honda", 6000, semaphore);
        Car car7 = new Car("Opel", 5000, semaphore);
        Car car8 = new Car("Kia", 8000, semaphore);

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
        car7.start();
        car8.start();

    }
}

class Car extends Thread {

    public String carName;
    public int duration;
    public Semaphore semaphore;

    //constructor
    public Car(String carName, int duration, Semaphore semaphore) {
        this.carName = carName;
        this.duration = duration;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println(this.carName + " wants to park");

        try {
            semaphore.acquire();    // parking slot is acquired
            System.out.println("--> " + this.carName + " used parking area");
            System.out.println(this.carName + " is being parked and waiting");
            Thread.sleep(duration);
            System.out.println(" <-- " + this.carName + " leaves parking area");
            semaphore.release();    // it'll be released from parking area
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
