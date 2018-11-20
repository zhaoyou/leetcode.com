package DP;

import org.junit.Test;

/**
 * reference:
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73077
 */
public class LongestCommonSubsequence {

    @Test
    public void test() {
        String A = "ABCD";
        String B = "EACB";

        System.out.println(A + " with " + B + " lcs: " + longestCommonSubsequence(A, B));
    }

    public int longestCommonSubsequence(String A, String B) {

        if (A == null || A.length() == 0 || B == null || B.length() == 0) return 0;

        int aLen = A.length();
        int bLen = B.length();

        int[][] dp = new int[aLen + 1][bLen + 1];

        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[aLen][bLen];
    }
}
