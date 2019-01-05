package DP;

import org.junit.Test;


/**
 * reference: http://www.cnblogs.com/grandyang/p/5294255.html
 */
public class CountingBits {

    @Test
    public void test() {
        System.out.println(countBits(0));
    }

    public int[] countBits(int num) {

        int dp[] = new int[num + 1];

        dp[0] = 0;


        for(int i = 1; i <= num; i++) {
            if (i % 2 == 0) dp[i] = dp[i / 2];
            else dp[i] = dp[i/2] + 1;
        }

        return dp;
    }
}
