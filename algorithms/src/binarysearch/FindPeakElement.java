package binarysearch;

import org.junit.Test;

/**
 * reference: 二分搜索参考
 * https://leetcode.com/problems/find-peak-element/discuss/50232/Find-the-maximum-by-binary-search-(recursion-and-iteration)
 */
public class FindPeakElement {

    @Test
    public void test() {
        int[] nums = {5, 4, 3,2,1};
        System.out.println(findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        int len = nums.length;

        if (nums.length == 1) return nums[0];

        for(int i = 0; i < len; i++) {

            if (i > 0 && i < len -1) {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
            } else if (i == 0) {
                if (nums[i] > nums[i + 1]) return i;
            } else if (i == len - 1) {
                if (nums[i] > nums[i - 1]) return i;
            }
        }
        return 0;

    }

    private int search(int[] nums, int left, int right) {
        if (left >= right) return -1;

        int mid = left + (right - left) / 2;

        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;

        int result = search(nums, left, mid - 1);
        int result2 = search(nums, mid + 1 , right);

        return result;

    }
}
