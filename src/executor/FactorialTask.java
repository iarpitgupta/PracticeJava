package executor;

import java.security.InvalidParameterException;
import java.util.concurrent.*;

public class FactorialTask implements Callable<Integer> {

    int number;

    public FactorialTask(int number) {
        this.number = number;
    }

    public Integer call() {
        int fact = 1;

        if (number < 0){
            throw new InvalidParameterException("Number should be positive.");
        }

        for (int count = number; count > 1; count--) {
            fact = fact * count;
        }

        return fact;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FactorialTask task = new FactorialTask(-5);
        Future<Integer> future = executorService.submit(task);

        System.out.println(future.get().toString());
//        System.out.println(future.get().toString());
        System.out.println("End");
    }
}
