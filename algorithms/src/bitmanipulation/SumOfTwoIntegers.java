package bitmanipulation;

import org.junit.Test;

/**
 * reference:
 * https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary:-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
 * http://www.cnblogs.com/grandyang/p/5451942.html
 */
public class SumOfTwoIntegers {

    @Test
    public void test() {
        int a = -3;
        int b = 1;
        System.out.println(getSum(a, b));
    }

    public int getSum(int a, int b) {
        while(b != 0) {
            int c = a ^ b;
            b = (a & b ) << 1;
            a = c;
        }
        return a;
    }
}
