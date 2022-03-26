package MultiThreading;

import java.util.concurrent.*;

/**
 * Execute task in multi-threading and get result using callable.
 */
public class Program8 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Program8 program8 = new Program8();
        Future<String> result = program8.executeTaskUsingCallable(executorService);
        System.out.println("Performing task while callable is executed");
        System.out.println(result.get());
        executorService.shutdown();

    }

    private Future<String> executeTaskUsingCallable(ExecutorService executorService) {

        Callable<String> callable = () -> {
            System.out.println("Executing task using callable");
            TimeUnit.SECONDS.sleep(4);
            return "This is the result";
        };

        return executorService.submit(callable);
    }
}
