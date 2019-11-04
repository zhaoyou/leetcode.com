package binarysearch;

import org.junit.Test;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;

        if (m > n) return findMedianSortedArrays(nums2, nums1);

        int left_max , right_min;
        int imin = 0, imax = m;

        while(imin <= imax) {

            int i = (imin + imax) / 2;
            int j = (m + n + 1) / 2 - i;

            if (i < m && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            } else if (i > 0 &&  nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else {

                if (i == 0) {
                    left_max = nums2[j - 1];
                } else if (j == 0) {
                    left_max = nums1[i - 1];
                } else {
                    left_max = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1) return left_max;

                if (i == m) {
                    right_min = nums2[j];
                } else if (j == n)  {
                    right_min = nums1[i];
                } else {
                    right_min = Math.min(nums1[i], nums2[j]);
                }

                return (left_max + right_min ) / 2.0;

            }
        }
        return 0.d;
    }

    @Test
    public void test() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
