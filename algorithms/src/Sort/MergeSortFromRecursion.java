package Sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * reference: https://zh.wikipedia.org/wiki/%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F
 */
public class MergeSortFromRecursion {

    @Test
    public void mergeSort() {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        int [] temp = new int[arr.length];
        helper(arr, temp, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void helper(int[] arr, int[] temp, int start, int end) {
        if (start >= end) return;

        int mid = start +( (end - start) / 2);


        helper(arr, temp, start, mid);
        helper(arr, temp, mid + 1, end);

        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;

        int k = start;

        while(start1 <= end1 && start2 <= end2)
            temp[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];


        while(start1 <= end1) temp[k++] = arr[start1++];


        while (start2 <= end2) temp[k++] = arr[start2++];

        for(k = start ; k <= end; k++) {
            arr[k] = temp[k];
        }

    }
}
