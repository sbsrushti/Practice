package practice2021.thread.demo0;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadApp {

    static Random random = new Random(System.currentTimeMillis());
    public static void main(String[] args) throws InterruptedException{

        Compute compute = new Compute();

        Thread incrementThd = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    compute.increment();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ignored) {

                    }
                }
            }
        });

        Thread decrementThd = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    compute.decrement();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ignored) {

                    }
                }
            }
        });

        incrementThd.start();
        decrementThd.start();

        incrementThd.join();
        decrementThd.join();

        System.out.println(compute.counter);
    }

}

class Compute {

    ReentrantLock lock = new ReentrantLock();
    int counter = 0;

    public void increment() {
        System.out.println("y");
        lock.lock();
        counter++;
        lock.unlock();
    }

    public void decrement() {
        System.out.println("x");
        lock.lock();
        counter--;
        lock.unlock();
    }
}
