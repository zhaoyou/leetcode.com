package DP;

import org.junit.Test;

public class ArithmeticSlices {

    @Test
    public void test() {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(numberOfArithmeticSlices(A));
    }

    public int numberOfArithmeticSlices(int[] A) {

         int res = 0;
         int len = A.length;

         int []dp = new int[len];

         for(int i = 2; i < len; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }

            res += dp[i];
         }

        return res;
    }
}
