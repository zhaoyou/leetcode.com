package Sort;

import org.junit.Test;

import java.util.Arrays;

public class QuickSortFromWIKI {

    public void sort(int[] arr, int left, int right) {
        if (left >= right || arr == null || arr.length <= 1) return;

        int i = left, j = right, pivot = arr[(left + right) / 2];

        while(i <= j) {

            while(arr[i] < pivot) { i++;}

            while(arr[j] > pivot) { j--;}

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

            if (i == j) {
                i++;
            }
        }

        sort(arr, left, j);
        sort(arr, i, right);
    }


    @Test
    public void test() {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
