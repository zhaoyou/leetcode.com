package Sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by zhaoyou on 01/03/2017.
 */
public class MergeSort {
    public int[] mergeSort(int arr[]) {
        int n = arr.length;

        if (n == 1) { return arr;}

        int mid = n / 2;

        int[] leftarr = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] rightarr = mergeSort(Arrays.copyOfRange(arr, mid, n));

        return merge(leftarr, rightarr);
    }

    public int[] merge(int [] leftarr, int [] rightarr) {

        int i = 0, k = 0, c = 0, leftLength = leftarr.length, rightLength  = rightarr.length;

        int[] combineArr = new int[leftLength + rightLength];

        while (i < leftLength && k < rightLength) {
            if (leftarr[i] > rightarr[k]) {
                combineArr[c++] = rightarr[k++];
            } else {
                combineArr[c++] = leftarr[i++];
            }
        }

        while(i < leftLength) {
            combineArr[c++] = leftarr[i++];
        }

        while(k < rightLength) {
            combineArr[c++] = rightarr[k++];
        }

        return combineArr;
    }

    private void display(int []arr) {
        for (int i : arr) {
            System.out.printf(" " + i);
        }
        System.out.println("");
    }

    @Test
    public void test() {
        int[] arr = {4,5,8,3,4,1};
        display(mergeSort(arr));
    }

}
