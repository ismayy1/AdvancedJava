package threads_02;

import java.util.concurrent.Semaphore;

public class Semaphore01 {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(4);

        Car car1 = new Car("Chevrolet Camaro", 5000, semaphore);
        Car car2 = new Car("BMW 840i", 8000, semaphore);
        Car car3 = new Car("Audi a8", 3000, semaphore);
        Car car4 = new Car("Honda civic", 4000, semaphore);
        Car car5 = new Car("Porsche Taycan", 6000, semaphore);
        Car car6 = new Car("Ferrari LaFerrari", 8000, semaphore);
        Car car7 = new Car("Bugatti Chiron", 5000, semaphore);
        Car car8 = new Car("Tesla Model S Plaid", 4000, semaphore);

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

    public Car(String carName, int duration, Semaphore semaphore) {
        this.carName = carName;
        this.duration = duration;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println(this.carName + " wants to park.");
        try {
            semaphore.acquire();    // Asks for permission
            System.out.println(">>>>> " + this.carName + " parked.");
            Thread.sleep(duration);

            System.out.println("<<<<< " + this.carName + " left the lot.");
            semaphore.release();    // Returns the permission back
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}