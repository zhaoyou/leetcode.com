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
}
