package binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int start = 0, end = A.length - 1;

        while(start < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
                start = mid + 1;
            } else if (A[mid] < A[mid - 1] && A[mid] > A[mid + 1]) {
                end = mid;
            } else {
                return mid;
            }
        }

        return -1;
    }

    @Test
    public void test() {
        int[] A = {};
        Assert.assertEquals(peakIndexInMountainArray(new int[]{0, 1, 0}), 1);
        Assert.assertEquals(peakIndexInMountainArray(new int[]{0, 2, 1, 0}), 1);
    }
}
