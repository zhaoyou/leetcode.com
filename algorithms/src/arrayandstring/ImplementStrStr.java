package arrayandstring;

import org.junit.Test;

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

    @Test
    public void test() {
        String haystack = "aaaaa";
        String needle = "";
        System.out.println(strStr(haystack, needle));
    }
}
