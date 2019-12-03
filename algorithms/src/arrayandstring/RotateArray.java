package arrayandstring;

import org.junit.Test;

import java.util.Arrays;

/**
 * reference
 * https://leetcode.com/problems/rotate-array/discuss/54250/Easy-to-read-Java-solution
 */
public class RotateArray {
    /**
     *  1, 2, 3, 4, 5, 6, 7
     *  7, 6, 5, 4, 3, 2, 1
     *  5, 6, 7  <=====> 1, 2, 3, 4
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;

        if (k % nums.length == 0) return ;

        k = k % nums.length;

        // 整个反转
        for(int i = 0; i < nums.length / 2; i++)
            swap(nums, i, nums.length - i - 1);


        // 反转k后面部分
        int left = k, right  = nums.length - 1;
        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }


        // 反转前面k部分
        left = 0;
        right = k - 1;

        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }

    }


    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        helper(nums, 0, nums.length - 1);
        helper(nums, 0, k - 1);
        helper(nums, k, nums.length - 1);
    }


    private void helper(int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right++;
        }
    }



        private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,4,5,6,7, 8};
        int k = 6;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
