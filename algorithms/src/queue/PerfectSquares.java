package queue;

import org.junit.Test;

import java.util.*;

public class PerfectSquares {

    int min = 0;

    public int numSquares(int n) {

        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i = 1; i <= n; i++) {

            for (int j = 1 ; j * j <=i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }


    @Test
    public void test() {
        int n = 1111000;

        long start = System.currentTimeMillis();
        System.out.println(numSquares(n));
        System.out.println("cost time: " + (System.currentTimeMillis() - start));
    }
}
