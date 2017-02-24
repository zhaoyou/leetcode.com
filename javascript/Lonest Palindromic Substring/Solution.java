
public class Solution {

    public static void main(String[] args) {
      System.out.println(new Solution().longestPalindrome(args[0]));
    }

    public String longestPalindrome(String s) {
      int len = s.length();
      boolean [][] dp = new boolean[len][len];
      if (len == 2 && s.charAt(0) == s.charAt(1)) { return s;}
      int maxLen = 0;
      int left = 0;
      int right = 0;

      // 初始化，【i][i] 单个字符串是回文数
      for (int i = 0; i < len; i++) {
        for (int j = 0; j < len; j++) {
          if (i >= j) {
            dp[i][j] = true;
          } else {
            dp[i][j] = false;
          }
        }
      }

      for (int i = 1; i < len; i++) {
        for (int j = 0; j + i < len; j++) {
            int k = j + i;
            if (s.charAt(j) != s.charAt(k)) {
              dp[j][k] = false;
            } else {
              // 相邻的两个数，只要相邻（2，3）相等 所以 （3，2）也是相等的。
              dp[j][k] = dp[j + 1][k -1];
              // 判断长度
              if (dp[j][k]) {
                if (k - j > maxLen) {
                  maxLen = k -j;
                  left = j;
                  right = k;
                }
              }
            }
        }
      }

      return s.substring(left, right + 1);
    }

}
