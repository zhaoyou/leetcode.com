package String;

import org.junit.Test;

/**
 * reference: https://zxi.mytechroad.com/blog/string/leetcode-859-buddy-strings/
 */
public class BuddyStrings {


    @Test
    public void test() {
        String A = "ba", B = "ab";
        System.out.println(buddyStrings(A, B));
    }


    public boolean buddyStrings(String A, String B) {

        if (A.length() != B.length()) return false;

        int[] a = new int[26];
        int[] b = new int[26];

        int diff = 0;

        for(int i = 0; i < A.length(); i++) {
            a[A.charAt(i) - 'a'] ++;
            b[B.charAt(i) - 'a'] ++;

            if (A.charAt(i) != B.charAt(i)) diff++;
        }



        for(int j = 0; j < a.length; j++) {
            if (diff == 0 && a[j] > 1) return true;
            if (a[j] != b[j]) return false;
        }

        return diff == 2;
    }
}
