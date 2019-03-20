package DP;

import org.junit.Test;

import java.util.Arrays;

/**
 * reference:
 * https://leetcode.com/problems/perfect-squares/discuss/71488/Summary-of-4-different-solutions-(BFS-DP-static-DP-and-mathematics)
 * http://www.cnblogs.com/grandyang/p/4800552.html
 */
public class PerfectSquares {

    @Test
    public void test() {
        int n = 13;
        System.out.println(numSquares(n));
    }

    public int numSquares(int n) {
        if (n == 0) return 0;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
