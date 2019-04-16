package interviewMedium.dp;

import org.junit.Test;

/**
 * reference:
 * https://leetcode.com/articles/jump-game/
 *
 */
public class JumpGame {

    @Test
    public void test() {
        int [] nums = {4, 5, 1, 0, 0, 0, 0};
           //{3,2,1,0,4};
        System.out.println(canJump2(nums));
    }


    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) return false;
        if (nums.length > 1 && nums[0] == 0) return false;

        int[] dp = new int [nums.length];

        dp[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {


            dp[i] = Math.max(nums[i], dp[i - 1] - 1);

            if (dp[i] == 0 && i != nums.length - 1) return false;

            //System.out.println("dp[" + i + "] = " + dp[i]);
        }

        return dp[nums.length - 1] >= 0;
    }

    public boolean canJump2(int[] nums) {

        if (nums == null || nums.length == 0) return false;
        if (nums.length > 1 && nums[0] == 0) return false;

        //int[] dp = new int [nums.length];

        //dp[0] = nums[0];

        int prev = nums[0];

        for(int i = 1; i < nums.length; i++) {


            prev = Math.max(nums[i], prev - 1);

            if (prev == 0 && i != nums.length - 1) return false;

            //System.out.println("dp[" + i + "] = " + dp[i]);
        }

        return prev >= 0;
    }
}
