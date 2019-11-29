package arrayandstring;

import org.junit.Test;

import java.util.Arrays;

public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        if ("".equals(haystack)) return -1;

        int m = haystack.length();
        int n = needle.length();

        for(int i = 0; i < m - n + 1; i++) {
            int j = 0;
            if (haystack.charAt(i) == needle.charAt(j)) {
                while(j < n && haystack.charAt(i + j) == needle.charAt(j)) j++;
                if (j == n) return i;
            }
        }
        return -1;
    }

    /**
     * KMP算法解释
     * https://www.zhihu.com/question/21923021
     * http://www.matrix67.com/blog/archives/115
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {

        if (needle.equals("")) return 0;

        int[] next = generateNext(needle);

        System.out.println(Arrays.toString(next));

        int i = 0, j = 0;

        while(i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == needle.length()) return i - j;

        return -1;
    }

    private int[] generateNext(String pattern) {
        int[] next = new int[pattern.length()];

        int i = 0, j = -1;
        next[0] = -1;

        while(i < pattern.length() - 1) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        return next;
    }

    @Test
    public void test() {
        String haystack = "abbaabbaaba";
        String needle = "abbaaba";
        System.out.println(strStr2(haystack, needle));
    }
}
