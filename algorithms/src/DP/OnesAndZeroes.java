package DP;

import org.junit.Test;

public class OnesAndZeroes {

    @Test
    public void test() {
        String[] strs = {"10", "0", "1"};
        int m = 1, n = 1;
        System.out.println(findMaxForm(strs, m, n));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(String str: strs) {
            int zeroCount = 0, oneCount = 0;
            for(char c: str.toCharArray()) { if (c == '0') zeroCount++; else oneCount++;}
            for(int i = m; i >= zeroCount; i--) {
                for(int j = n; j >= oneCount; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroCount][j - oneCount] + 1);
                }
            }
        }
        return dp[m][n];
    }

}
