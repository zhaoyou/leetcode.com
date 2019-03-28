package interviewEasy.String;

import org.junit.Test;

/**
 * reference:
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/884/discuss/4643/Java-Solution-with-4-steps-explanations
 */
public class StringToInteger {

    @Test
    public void test() {
        String str = "0-1";
        System.out.println(myAtoi(str));
    }

    public int myAtoi(String str) {
        //int i  = 0;
        int res = 0;
        boolean hasSign = false;

        boolean isPos = true;

        boolean hasNumber = false;

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ' && hasSign) break;
            if (c == ' ' && hasNumber) break;
            if (c == ' ') continue;

            if (c == '-' && hasSign) break;
            if (c == '-' && hasNumber) break;
            if (c == '-') {
                isPos = false;
                hasSign = true;
                continue;}

            if (c == '+' && hasSign) break;
            if (c == '+' && hasNumber) break;

            if (c == '+') {
                hasSign = true;
                continue;
            }


            if ( c >= '0' &&  c <= '9') {

                hasNumber = true;

                int sum = res * 10 + (c - '0');

                if (sum / 10 != res) { // 判断超限的条件
                    return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                res = sum;
            } else {
                break;
            }
        }

        return isPos ? res : -res;

    }
}
