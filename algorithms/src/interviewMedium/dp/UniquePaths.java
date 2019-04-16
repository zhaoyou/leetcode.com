package interviewMedium.dp;

import org.junit.Test;

public class UniquePaths {

    @Test
    public void test() {
        int m = 3, n = 2;
        System.out.println(uniquePaths(m, n));
    }

    public int uniquePaths(int m, int n) {

        // 使用一行保留所有的中间状态
        int[] dp = new int[m];

        for(int i = 0; i < m; i++) dp[i] = 1;

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                dp[j] = dp[j] + dp[j - 1];  // j - 1 是前一个状态  等于号后面 j 是上一次的数量
            }
        }
        return dp[m - 1];
    }
}
