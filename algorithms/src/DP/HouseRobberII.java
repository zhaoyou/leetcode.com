package DP;

import org.junit.Test;

/**
 * reference: http://www.cnblogs.com/grandyang/p/4518674.html
 */
public class HouseRobberII {

    @Test
    public void test() {
        int[] nums = {4,1,2,7,5,3,1};
        System.out.println(rob(nums));
    }

    public int rob(int[] nums) {

        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(
                getMax(nums, 0, nums.length - 1),
                getMax(nums, 1, nums.length)
        );
    }

    private int getMax(int[] nums, int start, int end) {
        int even = 0, odd = 0;

        for (; start < end; start++) {
            if (start % 2 == 0) {
                even = Math.max(even + nums[start], odd);
            } else {
                odd = Math.max(odd + nums[start], even);
            }
        }

        return Math.max(even, odd);
    }
}
