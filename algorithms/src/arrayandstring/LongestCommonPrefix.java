package arrayandstring;

import org.junit.Test;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        String prev = strs[0];

        for(int i = 1; i < strs.length; i++) {

            int k = 0, j = 0;

            while( k < prev.length() && j < strs[i].length() && prev.charAt(k) == strs[i].charAt(j)) { k++; j++;}
            if (k == 0) return  "";
            else prev = prev.substring(0, k);

        }
        return prev;
    }

    @Test
    public void test() {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
