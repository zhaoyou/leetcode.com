package DP;

import org.junit.Test;

public class UglyNumber {

    @Test
    public void test() {
        int num = -20;
        System.out.println("num: " + num + " isUgly: " + isUgly(num));
    }

    public boolean isUgly(int num) {

        if (num <= 0)  return false;
        if (num == 1) return true;

        if (num % 2 == 0) return isUgly( num / 2);
        else if (num % 3 == 0) return isUgly( num / 3);
        else if (num % 5 == 0) return isUgly(num / 5);

        return false;
    }
}
