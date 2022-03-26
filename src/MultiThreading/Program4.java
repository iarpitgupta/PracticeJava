package MultiThreading;

/**
 * Pause thread execution using sleep()
 */
public class Program4 {
    public static void main(String[] args) {
        String[] messages = {"If I can stop one heart from breaking,",
                "I shall not live in vain.",
                "If I can ease one life the aching,",
                "Or cool one pain,",
                "Or help one fainting robin",
                "Unto his nest again,",
                "I shall not live in vain"};

        Runnable runnable = () -> {

            for (String message : messages) {
                System.out.println(message);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
