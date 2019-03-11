package Array;

import org.junit.Test;

public class MissingNumber {

    @Test
    public void test() {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = len * (len + 1) / 2;
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result += nums[i];
        }
        return sum - result;
    }
}
