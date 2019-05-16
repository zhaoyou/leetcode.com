package heap;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class HeapSort {

    @Test
    public void test() {
        int[] arr = new int[] {3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6};
        //sort2(arr);
        //System.out.println(Arrays.toString(arr));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int seconds = calendar.get(Calendar.SECOND);

        System.out.println(seconds);
    }


    public void sort(int[] arr) {


        // 数据堆化
        int len = arr.length - 1;

        int beginIndex = (len - 1) >> 1;

        for(int i = beginIndex; i>= 0; i--) {
            maxHeapify(arr, i, len);
        }


        // 每次交换最后一个和第一个最大值，满足最大值放到最后
        // 同事 heapify的时候不在处理已经掉的。
        for(int i = len; i > 0; i--) {
            swap(arr, i, 0);
            maxHeapify(arr, 0, i - 1);
        }


    }

    public void sort2(int[] arr) {

        // 数据堆化
        int len = arr.length - 1;

        int beginIndex = (len - 1) >> 1;

        for(int i = beginIndex; i>= 0; i--) {
            minHeapify(arr, i, len);
        }


        // 每次交换最后一个和第一个最大值，满足最大值放到最后
        // 同事 heapify的时候不在处理已经掉的。
        for(int i = len; i > 0; i--) {
            swap(arr, i, 0);
            minHeapify(arr, 0, i - 1);
        }

    }

    private  void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void minHeapify(int[] arr, int index, int len) {
        int leftChild = index * 2 + 1;
        int rightChild = leftChild + 1;

        int min = leftChild;

        if (leftChild > len) return;

        if (rightChild <= len && arr[rightChild] < arr[leftChild]) min = rightChild;

        if (arr[min] < arr[index]) {
            swap(arr, index, min);
            minHeapify(arr, min, len);
        }
    }


    private void maxHeapify(int[] arr, int index , int len) {
        int leftChild = index * 2 + 1;
        int rightChild = leftChild + 1;

        int max = leftChild;

        if (leftChild > len) return;

        if (rightChild <= len && arr[rightChild] > arr[leftChild]) max = rightChild;

        if (arr[max] > arr[index]) {
            swap(arr, index, max);
            maxHeapify(arr, max, len);
        }
    }



}
