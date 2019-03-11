package binarysearch;

import org.junit.Test;

/**
 * reference: 二分搜索参考
 * http://www.cnblogs.com/grandyang/p/4217175.html
 * https://leetcode.com/problems/find-peak-element/discuss/50232/Find-the-maximum-by-binary-search-(recursion-and-iteration)
 */
public class FindPeakElement {

    @Test
    public void test() {
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement3(nums));
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

    // 利用局部波峰，只要递减了。前一个就肯定是波峰。
    public int findPeakElement2(int[] nums) {
        int len = nums.length;

        for(int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) return i - 1;
        }
        return -1;
    }


    // 利用局部波峰，只要递减了。前一个就肯定是波峰。
    public int findPeakElement3(int[] nums) {
        int len = nums.length;

        int left = 0, right = len - 1;

        while(left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;

        }
        return right;
    }

}
