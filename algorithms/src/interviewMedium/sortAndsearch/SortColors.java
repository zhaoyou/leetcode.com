package interviewMedium.sortAndsearch;

import org.junit.Test;

import java.util.Arrays;


/**
 * reference:
 * http://www.cnblogs.com/grandyang/p/4341243.html
 */
public class SortColors {

    @Test
    public void test() {
        int nums[] = {0, 1, 2, 0, 2, 1};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {

        int len = nums.length;

        int min = 0;

        for(int i = 0; i < len; i++) {
            min = i;
            for(int j = i + 1; j < len; j++) {
                if(nums[j] <= nums[i]) min = j;
            }
            swap(nums, i, min);
        }

    }


    public void sortColors2(int[] nums) {

        int left = 0, right = nums.length - 1;

        for(int i = 0; i <= right; i++) { // i <= right 需要遍历到最后一个数
            if (nums[i] == 0) {
                swap(nums, i, left++);
            } else if (nums[i] == 2) {
                swap(nums, i--, right--); // i-- 需要减一，因为从后面交互过来的数字也要判断，循环会+1.所以这里需要-1
            }
        }

    }

    private void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
