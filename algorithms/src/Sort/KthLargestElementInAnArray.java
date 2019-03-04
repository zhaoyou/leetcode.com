package Sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * reference: http://www.cnblogs.com/grandyang/p/4539757.html
 */
public class KthLargestElementInAnArray {

    @Test
    public void test() {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1;

        while(true) {
            System.out.println("beigin parition: start:" + start + " end: " + end);
            int p = parition(nums, start, end);
            System.out.println("p: " + p + " k-1: " + (k - 1));
            if (p == k - 1) return nums[p];
            else if(p > k - 1) end = p - 1;
            else start = p + 1;
        }
    }

    public int parition(int[] nums, int left, int right) {

//        if (left >= right) return left;
//
//        int mid = nums[left + (right - left)/2];
//
//        while(left <= right) {
//
//
//            while (nums[left] > mid) left++;
//
//            while(nums[right] < mid) right --;
//
//
//            if (left < right) {
//                swap(nums, left, right);
//                left++;
//                right--;
//            }
//
//            if (left == right) {
//                left++;
//            }
//        }
//
//        System.out.println("left: " + left + " right: " + right + " array: " + Arrays.toString(nums));
//
//        return left;

        int pivot = nums[left], l = left + 1, r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot) ++l;
            if (nums[r] <= pivot) --r;
        }
        swap(nums, left, r);
        return r;
    }

    private void swap(int[] num, int start, int end) {
        int temp = num[start];
        num[start] = num[end];
        num[end] = temp;
    }
}
