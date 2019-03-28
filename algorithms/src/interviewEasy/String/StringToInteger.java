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
        System.out.println(myAtoi2(str));
    }

    public int myAtoi2(String str) {
        int len = str.length();

        if (str.isEmpty()) return 0;

        int j = 0;

        int sign = 1;

        int res = 0;

        // 去掉前置空格
        while(j < len && str.charAt(j) == ' ') j++;

        // 处理有可能的符号位
        if (j < len && (str.charAt(j) == '-' || str.charAt(j) == '+')) {
            sign = str.charAt(j++) == '-' ? -1 : 1;
        }

        // 处理有效的数字
        while(j < len) {
            char c =str.charAt(j++);

            if (c < '0' || c > '9') break;

            int sum = res * 10 + (c - '0');

            // 判断数字是否合法integer
            if (sum / 10 != res) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = sum;
        }

        return res * sign;

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
