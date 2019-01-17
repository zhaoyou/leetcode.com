package DP;

import org.junit.Test;

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 *
 * Input: [1, 5, 11, 5]
 *
 * Output: true
 *
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: [1, 2, 3, 5]
 *
 * Output: false
 *
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 */
public class PartitionEqualSubsetSum {

    @Test
    public void test() {
        int[] nums = {1, 2, 4, 4, 5};
        System.out.println(canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int i = 0; i < nums.length; i++) sum+=nums[i];


        if ((sum & 1) == 1) return false; // 如果是和是基数，肯定不能平均分

        sum = sum >> 1; // 平均

        // dp[i]表示数字i是否是原数组的任意个子集合之和
        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;

        for(int num: nums) {
            for(int j = sum; j >= num; j--) {  // 从之和开始，递减到当前 num。而不是从 num 到 target 为了避免 num = 1 的情况
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[sum];
    }
}
