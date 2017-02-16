package twoSum;

/**
 * Created by zhaoyou on 16/02/2017.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for(int i = 0; target >= nums[i] && i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
