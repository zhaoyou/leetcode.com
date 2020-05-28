package DP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 *
 * Example:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 *
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test cases.
 *
 *
 * reference:
 * https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation
 *
 */
public class CombinationSumIV {

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        int target = 4;
        Long start = System.currentTimeMillis();
        System.out.println(combinationSum4(nums, target));
        System.out.println("cost: " +( System.currentTimeMillis() - start )+ " ms");
        start = System.currentTimeMillis();

        System.out.println(combinationSum4_2(nums, target));
        System.out.println("cost: " +( System.currentTimeMillis() - start )+ " ms");

    }

    public int combinationSum4(int[] nums, int target) {
        //Arrays.sort(nums);
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return  dfs(nums, target, dp);
    }

    private int dfs(int[] nums, int remain, int[] dp) {

        if (dp[remain] != -1) return dp[remain];

        if (remain < 0) return 0;
        if (remain == 0) return 1;
        else {
            int res = 0;

            for(int i = 0; i < nums.length; i++) {
                if (remain >= nums[i])
                res += dfs(nums, remain - nums[i], dp);
            }
            dp[remain] = res;
            return res;
        }
    }


    public int combinationSum4_2(int[] nums, int target) {

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for(int i = 1; i <= target; i++) {

            for(int num: nums) {

                if (i >= num) {
                    dp[i] = dp[i] + dp[i - num];
                }
            }
        }

        return dp[target];

    }
}
