package String;

import org.junit.Test;

/**
 * reference: http://www.cnblogs.com/grandyang/p/7404777.html
 */
public class PalindromicSubstrings {

    @Test
    public void test() {
        String s = "aaa";
        System.out.println(s + " countSubString: " + countSubstrings(s));
    }

    public int countSubstrings(String s) {

        if (s.length() == 0) return 0;

        int len = s.length();
        int res = 0;

        for (int i = 0; i < len; i++) {
            res += helper(s, i, i);
            res += helper(s, i, i + 1);
        }

        return res;
    }

    private int helper(String s, int k, int j) {
        int count = 0;
        while (k >=0 && j < s.length() && s.charAt(k) == s.charAt(j) ) {
            k--;j++; count++;
        }
        return count;
    }
}
