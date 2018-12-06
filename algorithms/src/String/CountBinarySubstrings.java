package String;

import org.junit.Test;

import java.util.Stack;


/**
 * reference: http://www.cnblogs.com/grandyang/p/7716150.html
 */
public class CountBinarySubstrings {


    @Test
    public void test() {
        String s = "00110011";
        System.out.println(s + " --> " + countBinarySubstrings(s));
    }


    /**
     * Input: "00110011"
     * Output: 6
     * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
     *
     * Notice that some of these substrings repeat and are counted the number of times they occur.
     *
     * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
     *
     * @param s
     * @return
     */

    public int countBinarySubstrings(String s) {

        if (s.length() == 1) return 0;

        int res = 0;

        int zeroCount = 0, oneCount = 0, len = s.length();

        for(int i = 0; i < len; i++) {
            if (i == 0) {
                if (s.charAt(i) == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            } else {
                if (s.charAt(i) == '0') {
                    zeroCount = s.charAt(i) == s.charAt(i - 1) ? zeroCount + 1 : 1;

                    if (oneCount >= zeroCount) res++;
                } else {
                    oneCount = s.charAt(i) == s.charAt(i - 1) ? oneCount + 1 : 1; // 当前是1 前一个也是1 则1的数据+1，否则代表第一次为1

                    if (zeroCount >= oneCount) res++;
                }
            }
        }

        return res;
    }
}
