package MultiThreading;

/**
 * Implementation of multi-threading by implementing Runnable interface.
 */

public class Program2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside thread " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Program2 program2 = new Program2();
        Thread thread1 = new Thread(program2);
        thread1.start();
        System.out.println("Inside thread " + Thread.currentThread().getName());
    }
}
