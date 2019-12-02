package arrayandstring;

import org.junit.Test;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = -1;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) count++;
            else { max = Math.max(max, count); count = 0;}
        }
        return Math.max(max, count);
    }

    @Test
    public void test() {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
