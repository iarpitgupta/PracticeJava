package MultiThreading;

/**
 * Implementation of multi-threading by extending Thread class.
 */
public class Program1 extends Thread {

    @Override
    public void run() {
        System.out.println("Inside thread " + currentThread().getName());
    }

    public static void main(String[] args) {
        Program1 program1 = new Program1();
        program1.start();
        System.out.println("Inside thread " + currentThread().getName());
    }
}
