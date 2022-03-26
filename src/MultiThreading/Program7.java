package MultiThreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Implement multi-threading, schedule task and
 * run task at defined interval using executor service.
 */
public class Program7 {
    public static void main(String[] args) {
        Program7 program7 = new Program7();
        program7.runScheduleTask();
        program7.runTaskAtFixedRate();
    }

    private void runScheduleTask() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Inside scheduled thread " + Thread.currentThread().getName());
        executorService.schedule(task, 5, TimeUnit.SECONDS);
    }

    private void runTaskAtFixedRate() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Inside periodic thread " + Thread.currentThread().getName());
        executorService.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
    }
}
