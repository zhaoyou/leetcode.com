package test;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort {

    @Test
    public void test() {
        int[] arr = {1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public void quickSort(int[] arr) {
        sort2(arr, 0, arr.length - 1);
    }

    /**
     * 以中间为基准点
     * @param arr
     * @param left
     * @param right
     */
    private void sort(int[] arr, int left, int right) {
        if (left >= right || arr.length == 0 || arr.length == 1) return;

        int pivot = arr[(left + right )/ 2];
        int i = left, j = right;

        while(i <= j) {
            while(arr[i] < pivot) i++;
            while(arr[j] > pivot) j--;

            if (i < j) {
                swap(arr, i, j);
                i++;
                j--;
            } else if (i == j) {
                i++;
            }
        }

        sort(arr, left, j);
        sort(arr, i, right);
    }

    private void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 以左边为基准点
     * @param arr
     * @param head
     * @param tail
     */
    private void sort2(int[] arr, int head, int tail) {

        if (head >= tail || arr == null || arr.length <= 1) return;

        int i = head + 1, j = tail;
        int pivot = arr[head];

        while(i < j) {


            while(i < j && arr[j] >= pivot) j--;

            while(i < j && arr[i] < pivot) i++;

            if (i < j) {
                swap(arr, i, j);
            }

            System.out.println("i: " + i + " j: " + j);
        }

        if (arr[head] > arr[i])
            swap(arr, head, i);

        sort2(arr, head, i - 1);
        sort2(arr, i + 1, tail);
    }
}
