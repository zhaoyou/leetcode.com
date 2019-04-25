package test;

import org.junit.Test;

import java.util.Arrays;

public class MergeSort {

    @Test
    public void test() {
        int[] arr = {1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        merge_sort_recursive(arr, new int[arr.length], 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void merge_sort_recursive(int[] arr, int[] temp, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;

        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;


        merge_sort_recursive(arr, temp, start1, end1);
        merge_sort_recursive(arr, temp, start2, end2);

        int k = start;

        while(start1 <= end1 && start2 <= end2) {
                if (arr[start1] < arr[start2]) {
                    temp[k++] = arr[start1++];
                } else {
                    temp[k++] = arr[start2++];
                }
        }

        while(start1 <= end1) temp[k++] = arr[start1++];

        while(start2 <= end2) temp[k++] = arr[start2++];


        for(k = start; k <= end; k++) {
            arr[k] = temp[k];
        }
    }
}
