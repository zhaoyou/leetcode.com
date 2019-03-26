package interviewEasy.Array;

import org.junit.Test;

public class RotateArray {


    @Test
    public void test() {
        int[] nums = {-1,-100,3,99};
        int k = 4;
        rotate2(nums, k);
        for(int i : nums) {
            System.out.println(i);
        }
    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length- 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {

        int len = nums.length;

        if (k % nums.length == 0) return;

        k = k % len;


        System.out.println("k: " + k);

        int[] target = new int[len];

        for(int i = 0; i < k; i++) {
            target[i] = nums[len - k + i];
        }

        for(int i = 0; i < len -k; i++) {
            target[k + i] = nums[i];
        }

        for(int i = 0; i < len; i++) {
            nums[i] = target[i];
            //System.out.println("--->" + nums[i]);
        }

    }
}
