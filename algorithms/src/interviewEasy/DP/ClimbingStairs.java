package interviewEasy.DP;

import org.junit.Test;

public class ClimbingStairs {

    @Test
    public void test() {
        int n = 4;
        System.out.println(climbStairs(n));
    }

    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int one = 1;
        int two = 2;

        int sum = 0;

        for(int i = 3; i <= n; i++) {
            sum = one + two;
            one = two;
            two = sum;
        }

        return sum;
    }
}
