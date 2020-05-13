package DP;

import org.junit.Test;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        if (A == null) return 0;

        int rows = A.length;
        int cols = A[0].length;

        int[][] dp = new int[rows][cols];

        int minResult = Integer.MAX_VALUE;

        for(int i = 0; i < cols; i++) {
            dp[0][i] = A[0][i];
        }


        for(int j = 1; j < rows; j++) {
            for(int k = cols - 1 ; k >= 0; k--) {
                int topLeft = (k == 0) ? Integer.MAX_VALUE : dp[j - 1][k - 1];
                int top = dp[j - 1][k];
                int topRight = (k == cols - 1) ? Integer.MAX_VALUE : dp[j - 1][k + 1];

                dp[j][k] = Math.min(topRight, Math.min(topLeft, top)) + A[j][k];

            }
        }

        for(int i = 0; i < cols; i++) minResult = Math.min(minResult, dp[rows - 1][i]);

        return minResult;
    }

    @Test
    public void test() {
        int[][] A = {
                {1, 2, 3},{4, 5, 6}, {7, 8, 9}
//                {-19,57},{-40,-5}
        };
        System.out.println(minFallingPathSum(A));
    }
}
