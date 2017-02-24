package MedianOfTwoSortedArrays;

import org.junit.Test;

/**
 * Created by zhaoyou on 22/02/2017.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total  = nums1.length + nums2.length;
        boolean isDouble = (total % 2 == 0);

        int i = 0, j = 0, index = 0;
        int median = 0;
        int prefix = 0;

        while(true) {
            if (i == nums1.length) {
                median = nums2[j++];
            } else if (j == nums2.length) {
                median = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                median = nums2[j++];
            } else {
                median = nums1[i++];
            }

            if (!isDouble && (index == total / 2)) {             // 单数
                return median;
            } else if (isDouble && index == (total/2 - 1)) {   // 双数的第一个数
                prefix = median;
            } else if (isDouble && index == (total/2)) {       // 双数的第二个数
                return (prefix + median + 0.0d) / 2;
            }
            index ++;
        }
    }

    /**
     * 二分查找采用递归的方法.
     * @param arr
     * @param start
     * @param end
     * @param kkey
     * @return
     */
    public int binary_search(int[] arr, int start, int end, int kkey) {
        if (start > end) return -1;

        int mid = start + (end - start) / 2;
        if (arr[mid] > kkey) {
            return binary_search(arr, start, mid - 1, kkey);
        } else if (arr[mid] < kkey) {
            return binary_search(arr, mid + 1, end, kkey);
        } else {
            return mid;
        }
    }

    /**
     * 二分查找采用while循环
     * @param arr
     * @param start
     * @param end
     * @param kkey
     * @return
     */
    public int binary_search_while(int[] arr, int start, int end, int kkey) {
        while(start <= end) {
            int mid = start + (end - end) / 2;
            if (arr[mid] > kkey) {
                end = mid - 1;
            } else if (arr[mid] < kkey) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] num1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println("The median is " + findMedianSortedArrays(num1, nums2));
    }

    @Test
    public void test2() {
        int[] num1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        System.out.println("The median is " + findMedianSortedArrays(num1, nums2));
    }

    @Test
    public void test_search() {
        int [] arr = new int[]{2,9, 11, 13, 19, 23};
        System.out.println(binary_search_while(arr, 0, arr.length - 1, 20));
    }
}
