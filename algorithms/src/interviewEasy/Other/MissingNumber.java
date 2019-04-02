package interviewEasy.Other;

import org.junit.Test;

public class MissingNumber {

    @Test
    public void test() {
        int[] nums = {3,0,1};
        System.out.println(missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result ^= nums[i];
            result ^= i;
        }
       return result ^ nums.length;
    }
}
