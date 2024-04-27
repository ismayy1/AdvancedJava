package threads;

import java.util.concurrent.*;

public class MyCallableTask implements Callable <Integer> {
    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i=1; i<=10; i++) {
            result += i;
        }
        return result;
    }
}

class Runner {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        MyCallableTask task = new MyCallableTask();

        Future<Integer> future = executorService.submit(task);

        executorService.shutdown();

        try {
            int result = future.get();
            System.out.println("Value returned from Callable: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
