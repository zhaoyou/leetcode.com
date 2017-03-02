package Sort;

import org.junit.Test;

/**
 * Created by zhaoyou on 02/03/2017.
 */
public class BubbleSort {
    public void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            boolean isReady = true;
            for (int j = 1; j < len - i; j++) {
                if (arr[j-1] > arr[j]) {
                    isReady = false;
                    swap(arr, j - 1, j);
                }
            }
            if (isReady) {break;}  // 如果剩余的已经不需要排序了, 则直接退出.避免不要要循环比较.
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private void display(int []arr) {
        for (int i : arr) {
            System.out.printf(" " + i);
        }
        System.out.println("");
    }

    @Test
    public void test() {
        int[] arr = {3, 6, 10, 7, 9};
        sort(arr);
        display(arr);
    }
}
