package DP;

import org.junit.Test;

/**
 * reference: http://www.cnblogs.com/grandyang/p/5138186.html
 * 
 */
public class CoinChange {

    @Test
    public void test() {
        int[] coins = {2, 3, 5};
        int amout = 0;
        System.out.println(coinChange(coins, amout));
    }

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        // 初始化默认值为最大值，为了最后求最小值是排除没有参与的情况。
        for(int i = 1; i < dp.length; i++) dp[i] = amount + 1;


        for(int i = 1; i <= amount; i++) {

            for(int coin: coins) {
                if (i  >= coin) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }


        return (dp[amount] > amount) ? -1 : dp[amount];
    }
}
