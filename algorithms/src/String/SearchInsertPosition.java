package String;

import org.junit.Test;

public class SearchInsertPosition {


    @Test
    public void test() {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
        System.out.println(searchInsert(nums, 0));

    }


    public int searchInsert(int[] nums, int target) {

        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if (nums[i] >= target) return i;
        }
        return len;
    }
}
