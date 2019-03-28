package interviewEasy.String;

import org.junit.Test;

/**
 * reference:
 * http://www.cnblogs.com/grandyang/p/4125588.html
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/discuss/4060/My-accepted-15-lines-of-code-for-Java
 */
public class ReverseInteger {

    @Test
    public void test() {
        int x = Integer.MAX_VALUE;
        System.out.println(x );
        System.out.println(x + 3);
        //System.out.println(reverse2(x));
    }

    public int reverse(int x) {
       long res = 0;

       boolean isNegative = false;

       if (x < 0) {
           isNegative = true;
           x *= -1;          // 如果x为 Integer.min_value * -1 还是等于本身 Integer.min_value.
       }

       while(x > 0) {
           res = res * 10 + x % 10;
           x /= 10;
       }


       if (res > Integer.MAX_VALUE) return 0;

       if (isNegative) {
           return new Long(-res).intValue();
       } else {
           return new Long(res).intValue();
       }
    }

    /**
     * @param x
     * @return
     */
    public int reverse2(int x) {

        int res = 0;

        while( x != 0) {
            // 应为 Integer.MAX_VALUE 2147483648
            // 由于输入的x是一个合法有效的int类型的值， 所以x满足不超过最大值的第一位肯定是 1 或者 2
            // 所以翻转回去之后只要前面满足不大于 214748364 （max_value / 10) 就肯定可以， 应为接上 1或者2 永远不可能大于8
            // 因此只要判断翻转后的值就可以处理越界的问题。
            if (Math.abs(res) > Integer.MAX_VALUE / 10) return 0;

            res = res * 10  + x % 10;

            x /= 10;
        }

        return res;
    }

}
