package interviewMedium;

import org.junit.Test;

public class MajorityElement {

    @Test
    public void test() {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int c = nums[0];
        int count = 1;

        for(int i = 1; i < nums.length; i++) {
            if (c == nums[i]) {
                count++;
            } else {
                if (count == 0) {
                    c = nums[i];
                } else {
                    count--;
                }
            }
        }
        return c;
    }
}