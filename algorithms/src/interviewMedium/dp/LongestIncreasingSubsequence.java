package interviewMedium.dp;

import org.junit.Test;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    @Test
    public void test() {
        int[] nums =
                {5, 4, 3, 2};
                //{1, 2, 3, 4};
                //{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        int maxLen = 1;

        for(int i =  1; i < nums.length; i++) {

            for(int j = 0 ; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        return  maxLen;
    }
}
