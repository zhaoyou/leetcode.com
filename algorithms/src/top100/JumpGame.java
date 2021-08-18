package top100;


public class JumpGame {

    public boolean canJump(int[] nums) {

        if (nums.length != 1 && nums[0] == 0) return false;
        if (nums.length == 1) return true;


        int prev = nums[0];

        for (int i = 1; i < nums.length; i++){
            prev = Math.max(nums[i], prev - 1);
            if (prev == 0 && i != nums.length - 1) return false;
        }
        return prev >= 0;

    }
}