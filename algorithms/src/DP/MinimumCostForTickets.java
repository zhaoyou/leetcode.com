package DP;

import org.junit.Test;

import java.util.Arrays;

public class MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {

        int[] dp = new int[366]; // 这个长度还可以是 days[days.length - 1] 元素，应为原数组是自增的。

        for(int k = 0; k < days.length; k++) dp[days[k]] = days[k];



        for(int i = 1; i < dp.length; i++) {

            if (dp[i] == 0) {
                dp[i] = dp[i - 1];
                continue;
            }


            dp[i] = dp[i - 1] + costs[0];

            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 7)] + costs[1]);

            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]);


        }

        return dp[days[days.length - 1]];
    }

    @Test
    public void test() {
        int[] days = {1,4,6,7,8,20}, costs = {2,7,15};
        System.out.println(mincostTickets(days, costs));
    }

}
