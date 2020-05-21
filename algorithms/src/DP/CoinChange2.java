package DP;

import org.junit.Test;

/**
 * https://leetcode.com/problems/coin-change-2/discuss/99212/Knapsack-problem-Java-solution-with-thinking-process-O(nm)-Time-and-O(m)-Space
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for(int i = 0; i < coins.length; i++) {
            for(int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        return dp[amount];

    }

    @Test
    public void test() {
        int amount = 5;
        int [] coins = {1, 2, 5};
        System.out.println(change(amount, coins));
    }

}
