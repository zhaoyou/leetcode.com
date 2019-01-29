package DP;

import org.junit.Test;

import java.util.Arrays;

/**
 * reference: http://www.cnblogs.com/grandyang/p/4938187.html
 */
public class LongestIncreasingSubsequence {


    @Test
    public void test() {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        int [] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = 0;
        for(int i = 0; i < len; i++) {

            for(int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
