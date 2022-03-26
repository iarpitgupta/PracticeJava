package MultiThreading;

/**
 * Implementation of multi-threading by creating anonymous class & lambda expression.
 */
public class Program3 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside thread " + Thread.currentThread().getName());
            }
        };

        Runnable runnable1 = () -> System.out.println("Inside thread " + Thread.currentThread().getName());

        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Inside thread " + Thread.currentThread().getName());
    }
}
