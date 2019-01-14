package DP;

import org.junit.Test;

/**
 * reference:
 * http://www.cnblogs.com/grandyang/p/5697621.html
 */
public class WiggleSubsequence {

    @Test
    public void test() {
        int[] nums = {3,3,3,2,5};
        System.out.println(wiggleMaxLength(nums));
    }

    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dpPositive = new int[len];
        int[] dpNegative = new int[len];

        for(int i = 0; i < len; i++) {
            dpPositive[i] = 1;
            dpNegative[i] = 1;
        }

        for(int i = 1; i < len; i++) {
            for(int j = 0 ; j < i; j++) {
                // 找到首个正摆动或负摆动
                if (nums[i] > nums[j]) dpPositive[i] = Math.max(dpPositive[i], dpNegative[j] + 1);
                else if (nums[i] < nums[j]) dpNegative[i] = Math.max(dpNegative[i], dpPositive[j] + 1);
            }
        }

        return Math.max(dpPositive[len - 1], dpNegative[len - 1]);
    }
}
