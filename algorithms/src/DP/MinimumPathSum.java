package DP;


import org.junit.Test;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 */
public class MinimumPathSum {

    @Test
    public void test() {
        int[][] grid = {
                {1,3,1},
                {1,5,3},
                {3,2,1}
        };

        System.out.println(minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int dp[][] = new int[rows][cols];


        dp[0][0] = grid[0][0];

        for(int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for(int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for(int j  = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }

        return dp[rows - 1][cols - 1];
    }
}
