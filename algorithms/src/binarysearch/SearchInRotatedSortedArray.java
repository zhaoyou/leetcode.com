package binarysearch;

import org.junit.Test;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return mid;

            System.out.println("mid: " + mid);

            if (nums[start] <= nums[mid]) {  // 左边的所有元素是升序 .必须包含 《= 才能处理  【3， 1】 target = 1 这种情况

                if (nums[mid] >= target && nums[start] <= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else {                        // 右边的所有元素是升序
                if (nums[mid] <= target && nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            System.out.println("start: " + start + " end: " + end);
        }
        return -1;
    }

    @Test
    public void test() {
        int[] nums = {3,1};
        int target = 1;
        System.out.println(search(nums, target));
    }
}
