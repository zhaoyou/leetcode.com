package bitmanipulation;

import org.junit.Test;

/**
 * reference:
 * https://leetcode.com/problems/power-of-three/discuss/77876/**-A-summary-of-all-solutions-(new-method-included-at-15:30pm-Jan-8th)
 */
public class PowerOfThree {


    @Test
    public void test() {
        int n = 60;
        System.out.println(isPowerOfThree(n));
    }

    public boolean isPowerOfThree(int n) {
        if (n > 1) {
            while(n % 3 == 0) {
                n = n / 3;
            }
        }
        return n == 1;
    }
}
