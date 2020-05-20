package DP;

import org.junit.Test;

public class NumberOfDiceRollsWithTargetSum {
    public int numRollsToTarget(int d, int f, int target) {


        int MOD = (int)Math.pow(10, 9) + 7;
        int [][] dp = new int[d + 1][target + 1];

        dp[0][0] = 1;

        for(int i = 1; i <= d; i++) {           // 每个骰子

            for(int j = 1; j <= target; j++) {   // 到达目标值

                for(int k = 1; k <= f; k++) {
                    if (j >= k) {
                        dp[i][j] =( dp[i][j] + dp[i - 1][j - k] ) % MOD;
                    } else {
                        break;
                    }
                }
            }
        }

        return dp[d][target];
    }

    @Test
    public void test() {
        int d = 30, f = 30, target = 500;
        System.out.println(numRollsToTarget(d, f, target));
    }
}
