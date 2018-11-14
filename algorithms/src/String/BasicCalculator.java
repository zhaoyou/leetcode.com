package String;

import org.junit.Test;

import java.util.Stack;


/**
 * reference: http://www.cnblogs.com/grandyang/p/4570699.html
 */
public class BasicCalculator {

    @Test
    public void test() {
        String s = " 1 + 1 ";
        String s2 =  " 2-1 + 2 ";
        String s3 = "(1+(4+5+2)-3)+(6+8)";

        System.out.println(s + "=" + calculate(s));
        System.out.println(s2 + "=" + calculate(s2));
        System.out.println(s3 + "=" + calculate(s3));
    }

    public int calculate(String s) {
        int sign = 1, num = 0, res = 0;
        Stack<Integer> stack = new Stack<>();
        int len = s.length();

        for(int i = 0; i < len; i++) {

            char c = s.charAt(i);

            if (c >= '0') {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                res +=  num * sign;
                num = 0;                    // 保存数字的变量清空
                sign = (c == '+') ? 1 : -1;   // 更新下一次计算的符号
            } else if ( c == '(') {
                stack.push(res);
                stack.push(sign);


                res = 0;
                sign = 1;

            } else if ( c== ')') {

                res += num * sign;
                num = 0;

                res = res * stack.pop();  // () 里面的res 需要计算（）之前的符号

                res = res + stack.pop(); // res = 当前res * sign + 括号之前的结果

                System.out.println("res: " + res);
            }
        }

        res += num * sign;

        return res;
    }
}
