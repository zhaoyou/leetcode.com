package Sort;

import org.junit.Test;

/**
 * https://www.tutorialspoint.com/data_structures_algorithms/images/quick_sort_partition_animation.gif
 * Created by zhaoyou on 28/02/2017.
 */
public class QuickSort {
    public void sort(int[] arr, int start, int end) {
        if (start >= end) { return;}
        int pivot = arr[end];
        int partition = partition(arr, start, end, pivot);
        sort(arr, start, partition - 1);
        sort(arr, partition + 1, end);

    }

    public int partition(int[] arr, int start, int end, int pivot) {
        int leftPointer = start;
        int rightPointer = end - 1;

        while(leftPointer <= rightPointer) {

            while (arr[leftPointer] < pivot && leftPointer <= rightPointer) {
                leftPointer++;
            }

            while(arr[rightPointer] > pivot && leftPointer <= rightPointer && rightPointer > 0) {
                rightPointer--;
            }

            if (leftPointer < rightPointer) {
                swap(arr, leftPointer, rightPointer);
            } else {
                break;
            }
        }
        swap(arr, leftPointer, end);
        return leftPointer;
    }
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private void display(int []arr) {
        for (int i : arr) {
            System.out.printf(" " + i);
        }
        System.out.println("");
    }

    @Test
    public void test() {
        int [] arr = {7,4,5,1,1,8};
        for(int i : arr) {
            System.out.printf(" " + i);
        }
        System.out.println("");
        sort(arr, 0, arr.length - 1);
        for(int i : arr) {
            System.out.printf(" " + i);
        }
    }
}
