
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
      for (int i = 0; i < len; i++) { dp[i][i] = true;}

      for (int i = 1; i < len; i++) {
        for (int j = 0; j + i < len; j++) {
            int k = j + i;
            // 0-1, 1-2, 2-3, .... n-2-n-1 相邻的只要相等也是回文数，double
            if (j + 1 == k ) {
              dp[j][k] = s.charAt(j) == s.charAt(k);
            } else {
              if (s.charAt(j) != s.charAt(k)) {
                dp[j][k] = false;
              } else {
                dp[j][k] = dp[j + 1][k -1];
              }
            }

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

      //for (int k = 0; k < len; k++) {
      //  for (int p = 0; p < len; p++) {
      //    System.out.print(dp[k][p] + ",");
      //  }
      //  System.out.println();
      //}
      return s.substring(left, right + 1);
    }

}
