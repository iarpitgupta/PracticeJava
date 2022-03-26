package inheritance;

import java.util.Date;

public class FibonacciDP {

    static int fib(int n) {
        if (n <= 1)
            return n;

        return fib(n - 1) + fib(n - 2);
    }

    static int fibCached(int n, int[] cache) {

        if (cache[n] != 0) {
            return cache[n];
        }

        if (n <= 1)
            return n;

        return cache[n] = fibCached(n - 1, cache) + fibCached(n - 2, cache);
    }

    public static void
    main(String args[]) {
        int N = 40;
        int cache[] = new int[N + 1];
        long a = new Date().getTime();
        for (int i = 0; i < N; i++) {

            System.out.print(fib(i) + " ");
        }
        long b = new Date().getTime();
        System.out.println("Time 1 : " + (b - a));

        for (int i = 0; i < N; i++) {

            System.out.print(fibCached(i, cache) + " ");
        }
        long c = new Date().getTime();
        System.out.println("Time 2 : " + (c - b));

    }
}
