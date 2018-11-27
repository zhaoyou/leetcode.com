package DP;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 */

import org.junit.Test;

/**
 * reference: http://www.cnblogs.com/grandyang/p/4028713.html
 */
public class MaximumProductSubarray {

    @Test
    public void test() {
        int[] nums = {2, 3, -2, 4};
        System.out.println( nums.toString() + "  maxProduct: " + maxProduct2(nums));
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        int len = nums.length;
        int res = nums[0];

        int[] max = new int[len];
        int[] min = new int[len];

        max[0] = nums[0];
        min[0] = nums[0];

        for(int i = 1; i < len; i++) {
            max[i] = Math.max(Math.max(nums[i] * max[i - 1], nums[i] * min[i - 1]), nums[i]);
            min[i] = Math.min(Math.min(nums[i] * max[i - 1], nums[i] * min[i - 1]), nums[i]);

            res = Math.max(res, max[i]);
        }

        return res;
    }

    public int maxProduct2(int[] nums) {
        if (nums.length == 1) return nums[0];

        int len = nums.length;
        int res = nums[0];

        int max = nums[0];
        int min = nums[0];


        for(int i = 1; i < len; i++) {

            int amax = max;
            int amin = min;

            max = Math.max(Math.max(nums[i] * amax, nums[i] * amin), nums[i]);
            min = Math.min(Math.min(nums[i] * amax, nums[i] * amin), nums[i]);

            res = Math.max(res, amax);
        }

        return res;
    }
}
