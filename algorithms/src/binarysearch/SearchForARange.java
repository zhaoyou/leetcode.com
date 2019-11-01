package binarysearch;

import org.junit.Test;

public class SearchForARange {

    public int[] searchRange(int[] nums, int target) {

        int  left = 0, right = nums.length;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left == nums.length || nums[left] != target) { return new int[] {-1, -1};}
        int begin = left;

        right = nums.length;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }




        return new int[]{begin , left - 1};
    }

    @Test
    public void test() {
        int[] nums = {7,7,7,7,7,7};
        int target = 7;
        int[] result = searchRange(nums, target);
        System.out.println(result[0] + ", " + result[1]);
    }

}
