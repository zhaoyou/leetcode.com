package DP;

import org.junit.Test;

public class LastStoneWeightII {
    public int lastStoneWeightII(int[] A) {
        int sum = 0;

        for(int stone: A) sum += stone;

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for(int stone: A) {

            for(int i = target ; i >= stone ; i--) {
                dp[i] = dp[i] | dp[i - stone];
            }
        }

        for(int i = target; i > 0; i--) {
            if (dp[i]) return sum - i - i;
        }

        return sum;
    }

    @Test
    public void test() {
        int[] A= {2,7,4,1,8,1};
        System.out.println(lastStoneWeightII(A));
    }
}