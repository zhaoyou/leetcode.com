package bitmanipulation;

import org.junit.Test;

/**
 * 其他方式
 * reference: https://leetcode.com/problems/number-of-1-bits/discuss/55099/Simple-Java-Solution-Bit-Shifting/246962
 */
public class NumberOf1Bits {

    @Test
    public void test() {
        int n = 5;
        System.out.println(hammingWeight(n));
    }

    public int hammingWeight(int n) {
        int count = 0;

        while(n != 0) {
            n = n & n - 1;
            count++;
        }

        return count;
    }
}
