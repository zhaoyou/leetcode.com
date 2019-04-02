package interviewEasy.Other;

import org.junit.Test;

public class NumberOf1Bits {

    @Test
    public void test() {
        int n = 2;
        System.out.println(hammingWeight(n));
    }

    public int hammingWeight(int n) {
        int count = 0;

        while(n != 0) {
            count = count + (n & 1);
            n = n >>>1;
        }

        return count;
    }
}
