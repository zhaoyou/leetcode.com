package interviewMedium.ArrayAndString;

import org.junit.Test;


/**
 * reference:
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/780/discuss/2921/Share-my-Java-solution-using-dynamic-programming
 */
public class LongestPalindromicSubstring {

    @Test
    public void test() {
        String s = "";
        System.out.println(longestPalindrome2(s));
    }

    public String longestPalindrome2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; // 标识 i -> j 之间是否是回文数。
        String res = "";

        for(int i = n - 1; i >= 0; i--) {
            dp[i][i] = true;
            for(int j = i ; j < n; j++) {
                //    121  22   dp[i+1][j-1] 可能会出现后面索引小于前面
                dp[i][j] = s.charAt(i) == s.charAt(j) && ( j - i < 3 || dp[i + 1][j - 1]); // 如果间距小于3的情况下，只要两边相等就是回文数。

                //System.out.println("dp[" + i + "][" + j + "] : " + dp[i][j]);

                if (dp[i][j] && (j - i + 1) > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;

    }

    public String longestPalindrome(String s) {

        if (s.length() < 2) return s;

        String result = String.valueOf(s.charAt(0));

        for(int i = 0; i < s.length(); i++) {
            int j = i + 1;
            while (j < s.length()) {
                if (isPalindrome(s, i, j)) {
                    j++;
                    result = result.length() < s.substring(i, j).length()
                            ? s.substring(i, j)
                            : result;

                } else {
                    j++;
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
