package interviewEasy.String;

import org.junit.Test;

public class LongestCommonPrefix {



    @Test
    public void test() {
        String [] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }


    public String longestCommonPrefix(String[] strs) {

        //StringBuffer sb = new StringBuffer();

        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        int len = strs.length;

        int subLen = strs[0].length();

        int i = 0;

        int dp[] = new int[26];

        while (i < subLen) {


            for(String str: strs) {
                if (i >= str.length()) return strs[0].substring(0, i);
                dp[str.charAt(i) - 'a'] ++;
            }


            if (dp[strs[0].charAt(i) - 'a'] != len) {
                return strs[0].substring(0, i);
            }

            dp[strs[0].charAt(i) - 'a'] = 0;

            //sb.append(strs[0].charAt(i));
            i++;
        }


        return strs[0].substring(0, i);//sb.toString();
    }

}
