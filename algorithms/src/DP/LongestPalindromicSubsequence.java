package DP;

import org.junit.Test;

import java.util.Arrays;


/**
 * reference:
 * https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution
 */
public class LongestPalindromicSubsequence {


    @Test
    public void test() {
        String s = "bbbcb";
        System.out.println(s + " ---> " + longestPalindromeSubseq(s));
    }

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++) {
            Arrays.fill(dp[i], - 1);
        }
        return dfs(s, dp, 0, len - 1);
    }

    private int dfs(String s, int[][] dp, int left, int right) {

        if (dp[left][right] != -1) return dp[left][right];

        if (left == right) return 1;
        if (left > right) return 0;

        if (s.charAt(left) == s.charAt(right)) {
            dp[left][right] = dfs(s, dp, left+ 1, right - 1) + 2;
        } else {
            dp[left][right] = Math.max(dfs(s, dp,left + 1, right), dfs(s, dp, left, right - 1));
        }

        return dp[left][right];
    }

}
