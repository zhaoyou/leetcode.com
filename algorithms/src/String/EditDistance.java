package String;

import org.junit.Test;

/**
 * reference:
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-edit-distance.html
 * http://www.cnblogs.com/grandyang/p/4344107.html
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 */
public class EditDistance {

    @Test
    public void test() {
        String word1 = "ros", word2 = "horse";
        System.out.println(word1 + " -> " + word2 + " minDistance: " + minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int dp[][] = new int[m+1][n+1];

        for(int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i <= m; i++) {

            dp[i][0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i- 1][j - 1];
                else // dp[i-1][j] 删除  dp[i][j-1] 添加  dp[i-1][j-1] 替换
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }

        return dp[m][n];
    }
}
