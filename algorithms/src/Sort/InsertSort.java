package Sort;

import org.junit.Test;

/**
 * Created by zhaoyou on 02/03/2017.
 */
public class InsertSort {
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;
            for(; j >= 0 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j+1] = temp;
        }
    }

    private void display(int []arr) {
        for (int i : arr) {
            System.out.printf(" " + i);
        }
        System.out.println("");
    }

    @Test
    public void test() {
        int[] arr = {3, 5, 10, 7, 9};
        sort(arr);
        display(arr);
    }
}
