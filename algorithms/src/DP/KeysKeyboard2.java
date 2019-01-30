package DP;

import org.junit.Test;

/**
 * reference:
 * https://leetcode.com/problems/2-keys-keyboard/discuss/105899/Java-DP-Solution
 * http://www.cnblogs.com/grandyang/p/7439616.html#commentform
 */
public class KeysKeyboard2 {

    @Test
    public void test() {
        int n = 27;
        System.out.println(minSteps(n));
    }

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for(int i = 2; i <= n; i++) {
            dp[i] = i;
            for(int j = 1; j < i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }

        return dp[n];
    }
}
