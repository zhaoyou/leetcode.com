package String;

import org.junit.Test;

import java.util.Stack;

/**
 * reference: http://www.cnblogs.com/grandyang/p/4601208.html
 */
public class BasicCalculatorII {

    @Test
    public void test() {
        String s = "3 + 1 * 2 ";
        String s2 =  " 3/2 ";
        String s3 =  " 3 +5 / 2 ";

        System.out.println(s + '=' + calculate(s));
        System.out.println(s2 + '=' + calculate(s2));
        System.out.println(s3 + '=' + calculate(s3));

    }

    public int calculate(String s) {

        /**
         * + sign = 1
         * - sign = -1
         * * sign = 2;
         */
        int num = 0, sign = 1, res = 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c >= '0') {
                num  =  c - '0';  // 代表数字


                int start = i + 1;

                // 依次读取数字
                while(start < len && s.charAt(start) >='0') {
                    num = num * 10 + (s.charAt(start) - '0');
                    start++;
                }

                i = start - 1;

                //System.out.println("sign: " + sign + " num: " + num);

                if (sign == -1 || sign == 1) {
                    num = sign == -1 ? -num  : num; // 如果数字前面是 - ，则去相反数
                    stack.push(num);
                } else if (sign == 2) {
                    int prev = stack.pop();
                    stack.push(prev * num);
                } else if (sign == 3) {
                    int prev = stack.pop();
                    stack.push(prev / num);
                }


            } else if ( c == '+' || c == '-') {
                sign = c == '+' ? 1 : -1;
            } else if ( c == '*' || c == '/') {
                sign = c == '*' ? 2 : 3;
            }
        }



        while(!stack.empty()) res += stack.pop();

        return res;
    }
}
