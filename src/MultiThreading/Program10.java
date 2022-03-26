package MultiThreading;

import java.util.concurrent.*;

public class Program10 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(() -> {
            System.out.println("Executing task...");
            Thread.sleep(4000);
            return "This is the result";
        });

        try {
            System.out.println(future.get(3, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            System.out.println("Failed to finish task in 3 seconds.");
        }
        executorService.shutdown();

    }
}
