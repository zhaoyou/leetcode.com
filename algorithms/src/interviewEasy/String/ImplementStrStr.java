package interviewEasy.String;

import org.junit.Test;

public class ImplementStrStr {

    @Test
    public void test() {
        String haystack = "aaaaaa";
        String needle = "bbaaa";
        System.out.println(strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {

        if (needle.equals("")) return 0;

        int len = haystack.length();

        for(int i = 0; i < len; i++) {

            int index = 0;

            int j = i;

            if (len - i < needle.length()) return -1;

            while(index < needle.length()
                    && i < len
                    && haystack.charAt(i) == needle.charAt(index)) {
                if (index == needle.length() -1) return j;
                if (j == len - 1) return -1;

                i++;
                index++;
            }

            i = j;
        }

        return -1;
    }
}