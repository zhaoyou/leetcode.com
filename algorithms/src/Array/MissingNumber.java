package Array;

import org.junit.Test;

/**
 * reference:
 * 使用异或^    
 * https://leetcode.com/problems/missing-number/discuss/69791/4-Line-Simple-Java-Bit-Manipulate-Solution-with-Explaination
 */
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
