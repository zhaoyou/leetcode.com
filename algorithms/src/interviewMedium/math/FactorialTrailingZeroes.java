package interviewMedium.math;

import org.junit.Test;

/**
 * reference:
 * https://www.cnblogs.com/grandyang/p/4219878.html
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/816/discuss/52373/Simple-CC++-Solution-(with-detailed-explaination)
 */
public class FactorialTrailingZeroes {

    @Test
    public void test() {
        int n = 100;
        System.out.println(trailingZeroes(n));
    }

    public int trailingZeroes(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }
}
