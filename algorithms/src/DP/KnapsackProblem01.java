package DP;

import org.junit.Test;

/**
 * reference:
 * https://blog.csdn.net/songshiMVP1/article/details/52350542
 */
public class KnapsackProblem01 {

    @Test
    public void test() {
        int v[] = {1, 100, 20, 60, 40};  //value of the items
        int wt[] = {1, 3, 2, 4, 1};        //weight of the items

        int n = 5;  //total items
        int w = 5;  //capacity of knapsack

        System.out.println(knapSack(w, n, v, wt));

    }



    public int knapSack(int w, int n, int[] value, int[] weight) {

        int[][] dp = new int[n + 1][ w + 1];

        for(int i = 1; i <=n; i++) {
            dp[i][0] = 0;
        }

        for(int j = 1; j < w; j++) {
            dp[0][j] = 0;
        }


        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= w; j++) {
                if (j >= weight[i - 1]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight[i - 1]] + value[i - 1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][w];
    }
}
