package arrayandstring;

import org.junit.Test;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int index = 1;
        int prev = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) continue;
            nums[index++] = nums[i];
            prev = nums[i];
        }
        return index;

    }

    @Test
    public void test() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }


}
