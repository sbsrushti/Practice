package practice2021.thread.demo3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolApp {

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runner(i));
        }

        System.out.println("All tasks submitted");
        // this is to inform the executor service to stop accepting any new tasks and
        // do a proper shut down after all the threads.
        executorService.shutdown();
        // waits for x amt of time until the tasks are complete
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        int temp = 0;

    }
}

class Runner implements Runnable {
    int id;
    Runner(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Thread " + this.id + " has started.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Thread " + this.id + " has completed.");
    }
}