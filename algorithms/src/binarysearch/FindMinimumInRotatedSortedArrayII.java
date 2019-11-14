package binarysearch;

import org.junit.Assert;
import org.junit.Test;

/**
 * reference:
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/discuss/48808/My-pretty-simple-code-to-solve-it?page=3
 */
public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {

            if (nums[left] < nums[right]) return nums[left];

            int mid = left + (right - left) / 2;

            if (nums[right] > nums[mid]) {
                right = mid;
            } else if (nums[right] < nums[mid])  {
                left = mid + 1;
            } else { // nums[right] == nums[mid] 不确定左右怎么移动，则直接 right - 1
                right--;
            }
        }
        return nums[left];
    }

    @Test
    public void test () {
        Assert.assertEquals(findMin(new int[]{1, 1, 1 }), 1);
        Assert.assertEquals(findMin(new int[]{2, 2, 2, 3, 3 }), 2);
        Assert.assertEquals(findMin(new int[]{2, 3, 4, 1}), 1);
        Assert.assertEquals(findMin(new int[]{2, 2, 3, 0, 0, 0, 0}), 0);
        Assert.assertEquals(findMin(new int[]{1, 2, 3, 4, 5, 6, 0}), 0);

        Assert.assertEquals(findMin(new int[]{1, 2}), 1);
        Assert.assertEquals(findMin(new int[]{1, 2, 2}), 1);

        Assert.assertEquals(findMin(new int[]{3,3,1,3}), 1);
        Assert.assertEquals(findMin(new int[]{3,1,3,3}), 1);


    }
}
