package DP;

import org.junit.Test;

/**
 * reference:
 * https://blog.csdn.net/camellhf/article/details/52711660
 * http://www.cnblogs.com/grandyang/p/5582633.html
 *
 */
public class CountNumbersWithUniqueDigits {

    @Test
    public void test() {
        System.out.println(countNumbersWithUniqueDigits(3));
    }

    public int countNumbersWithUniqueDigits(int n) {

        if (n == 0) return 1;

        int res = 10, count = 9;

        for (int i = 2; i <= n; i++) {
            count *= (11 - i);
            res += count;
        }

        return res;

    }
}
