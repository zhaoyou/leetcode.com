package Array;

import org.junit.Test;

public class FindTheDuplicateNumber {

    @Test
    public void test() {
        int[] arr = {3,1,3,4,2};
        System.out.println(findDuplicate(arr));
    }

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        for(int i = 0; i < nums.length; i++) {
            if (i != nums[i - 1]) {
                if (nums[i - 1] != nums[ nums[i - 1] - 1]) {
                    return nums[i - 1];
                }
                swap(nums, i - 1, nums[i-1]);
            }
        }

        return -1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
