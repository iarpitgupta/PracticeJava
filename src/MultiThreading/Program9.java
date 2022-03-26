package MultiThreading;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Program9 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        long startTime = new Date().getTime();

        Future<String> future = executorService.submit(() -> {
            Thread.sleep(4000);
            return "This is the result";
        });

        while (!future.isDone()) {
            System.out.println("Still executing task...");
            Thread.sleep(500);
            long timeElapsed = new Date().getTime() - startTime;
            if (timeElapsed > 3000) {
                future.cancel(true);
            }
        }

        if (future.isCancelled()) {
            System.out.println("Task is cancelled.");
        } else {
            System.out.println(future.get());
        }
        executorService.shutdown();
    }
}
