package interviewEasy.Array;

import org.junit.Test;

public class RemoveDuplicatesFromSortedArray {

    @Test
    public void test() {
        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int index = 0;
        for(int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}