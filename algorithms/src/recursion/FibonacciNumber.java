package recursion;

import org.junit.Test;

import java.util.Arrays;

public class FibonacciNumber {
    public int fib(int N) {
        if (N < 2) return N;

        int [] cached = new int[N + 1];
        Arrays.fill(cached, -1);

        return fib(N - 1) + fib(N -2 );
    }

    private int helper(int N, int[] cached) {
        if (cached[N] != -1) return cached[N];

        if (N < 2) return N;

        int result = helper(N - 1, cached) + helper(N - 2, cached);

        cached[N] = result;
        return result;
    }

    @Test
    public void test() {
        System.out.println(fib(5));
    }
}
