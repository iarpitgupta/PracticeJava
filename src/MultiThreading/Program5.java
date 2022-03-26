package MultiThreading;

/**
 * Waiting for  another thread completion using join.
 */
public class Program5 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Starting thread 1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ending thread 1");
        });

        Thread thread1 = new Thread(()->{
            System.out.println("Starting thread 2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ending thread 2");
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();

    }
}
