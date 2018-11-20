package DP;

import org.junit.Test;

/**
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.
 *
 * Example 1:
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 *
 * Note:
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 *
 * 最终就是通过找到两个字符串的最长公共子序列。 然后用 字符串的长度 - lcs 就是需要操作的步数
 */
public class DeleteOperationForTwoStrings {

    @Test
    public void test() {
        String word1 = "sea";
        String word2 = "eat";

        System.out.println(word1 + " " + word2 + " minDistance: " + minDistance(word1, word2));
    }


    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) return   (word2 == null) ? 0 : word2.length();
        if (word2 == null || word2.length() == 0) return   (word1 == null) ? 0 : word1.length();

        int aLen = word1.length();
        int bLen = word2.length();

        int[][] dp = new int[aLen + 1][bLen + 1];

        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return aLen - dp[aLen][bLen] + bLen - dp[aLen][bLen];
    }

}
