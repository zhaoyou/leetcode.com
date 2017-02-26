package LongestPalindromicSubstring;

import org.junit.Test;

/**
 * Created by zhaoyou on 25/02/2017.
 */
public class LongestPalindromicSubstring {

    /**
     * 暴力破解 O(n³) 判断每一个字串是否是回文字符串, 然后记下每一个的长度,得到最大的长度.
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int max = 0;
        String maxStr = "";
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String substr = s.substring(i, j + 1);
                int mid = substr.length() / 2;
                int k = 0;
                while( substr.charAt(k) == substr.charAt(substr.length() - 1 - k) && k < mid) {
                    k++;
                }
                if (k == mid) {
                    max = Math.max(max, substr.length());
                    maxStr= substr;
                }
            }
        }
        return maxStr;
    }

    public String longestPalindrome4dp(String s) {
        int len = s.length();
        if (len == 1) return s;
        int left = 0;
        int right = 0;
        int max = 0;
        boolean dp[][] = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        for (int i = 1; i < len; i++) {
            dp[i][i] = true;
            dp[i][i-1] = true;  // 当字符只有2个时,只要满足AB 想等即可 dp[A+1][B-1]其实就是字符串长度为2的字符串本身)
        }

        for (int i = 2; i <= len; i++) {
            for (int j = 0; j <= len - i  ; j++ ) {
                if (s.charAt(j) == s.charAt(j + i - 1) && dp[j+1][j + i - 2]) {
                    //System.out.println(j + ":" + (j + i - 1) + " 是回文数");
                    dp[j][j + i -1 ] = true;
                    if (i  > max) {
                        left = j;
                        right = j + i - 1;
                        max = i ;
                    }
                } else {
                    //System.out.println(j + ":" + (j + i - 1)+ " 不是回文数");
                    dp[j][j + i - 1] = false;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public void display(boolean dp[][]) {
        for(int i = 0 ; i < dp.length; i++) {
            for (int j = 0; j < dp.length;j++) {
                System.out.printf(" " + (dp[i][j] ? 1 : 0));
            }
            System.out.println("");
        }
    }

    @Test
    public void test_dp() {
        String str = "abcdef";
        System.out.println(str + " is palindrome: " + longestPalindrome4dp(str));
    }

    public boolean isPalindrome(String s) {
        int mid = s.length() / 2;
        int k = 0;
        while(s.charAt(k) == s.charAt(s.length() - 1 - k) && k < mid) {
            k++;
        }
        return k == mid;
    }

    @Test
    public void test1() {
        String str = "abcba";
        System.out.println(str + " is palindrome: " + isPalindrome(str));
    }

    @Test
    public void test2() {
        String str = "cbbd";
        System.out.println(str + " longestPalindrome:  " + longestPalindrome(str));
    }
}
