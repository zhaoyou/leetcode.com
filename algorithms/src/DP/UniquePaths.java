package DP;

import org.junit.Test;

/**
 * reference:
 * http://www.cnblogs.com/grandyang/p/4353555.html
 */
public class UniquePaths {


    @Test
    public void test() {
        System.out.println(uniquePaths2(7, 3));
    }

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;

        int [][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        if (m == 1 || n == 1) return 1;

        int [] dp = new int[n];
        dp[0] = 1;

        // 定义一个一维数组，一行行刷.节省空间
        for(int i = 0; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if (i == 0) dp[j] = 1;
                else dp[j] = dp[j] + dp[j-1];  // dp[j] 是上一行同列的值 + 同行前一列的值 dp[j - 1]
            }
        }

        return dp[n - 1];
    }
}
