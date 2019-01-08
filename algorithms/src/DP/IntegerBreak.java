package DP;

import org.junit.Test;

/**
 * reference: http://www.cnblogs.com/grandyang/p/5411919.html
 */
public class IntegerBreak {
    @Test
    public void test() {
        System.out.println(hammingWeight(6));
    }

    public int hammingWeight(int n) {

        if (n == 2 || n == 3) return n - 1;

        int res = 1;

        while (n > 4) {
            res *= 3;
            n -= 3;
        }

        res *= n;

        return res;
    }
}
