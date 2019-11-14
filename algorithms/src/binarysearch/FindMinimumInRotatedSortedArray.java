package binarysearch;

import org.junit.Test;

/**
 * reference: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/discuss/48493/Compact-and-clean-C++-solution
 *
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int end = nums.length - 1;      // 减1 是为了能够判断nums[start] < nums[end] outOfArrayIndex

        while (left < end) {

            if (nums[left] < nums[end]) return nums[left]; // 本身已经是没有rotated数组，则第一个元素就是最小值

            int mid = left + (end - left) / 2;

            if (nums[mid] >= nums[left]) { // 为什么要 >= 处理 mid = 0 left = mid 则计算后面的指 【2， 1】
                left = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[left];
    }

    @Test
    public void test() {
        int[] nums = {2 , 1 };
        System.out.println(findMin(nums));
    }

}
