package DP;

import org.junit.Test;

/**
 * reference: https://leetcode.com/problems/2-keys-keyboard/discuss/105899/Java-DP-Solution
 */
public class TwoKeysKeyboard {
    public int minSteps(int n) {
        if (n == 1) return 0;

        int[] dp = new int[n + 1];

        for(int i = 2; i <=n ; i++) {

            dp[i] = i;
            for(int j = i / 2; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + i / j;
                    break;                  //  保证最大的因数求出，就可以推出。最大因数 * 最小次数 = i
                }
            }
        }

        return dp[n];

    }


    @Test
    public void test() {
        int n = 121;
        System.out.println(minSteps(n));

    }
}
