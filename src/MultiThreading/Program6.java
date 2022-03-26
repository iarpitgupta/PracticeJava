package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Implement multi-threading using executor service.
 */
public class Program6 {
    public static void main(String[] args) {
        Program6 program6 = new Program6();
        program6.executeTaskWithSingleThread();
        program6.executeTasksInThreadPool();

    }

    private void executeTaskWithSingleThread() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Runnable runnable = () -> System.out.println("Inside single thread " + Thread.currentThread().getName());
        executorService.submit(runnable);
        executorService.shutdown();
    }

    private void executeTasksInThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable task1 = () -> {
            System.out.println("Inside task1 " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable task2 = () -> {
            System.out.println("Inside task2 " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable task3 = () -> {
            System.out.println("Inside task3 " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);
        executorService.shutdown();
    }
}
