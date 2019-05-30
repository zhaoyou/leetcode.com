package heap;

import org.junit.Test;

import java.util.Arrays;

public class TopK {

    @Test
    public void test() {
        int[] arr = {5,3,7,1,8,2,9,4,7,2,6,6};
        int k = 1;
        findTopK(arr, k);
        System.out.println("find topK: \n" + Arrays.toString(arr));
    }

    public void findTopK(int[] arr, int k) {

        // 使数据的前K个元素满足最小堆化特性

        int heapLen = k - 1;

        int beginIndex = (heapLen - 1) / 2;  // 遍历的K个元素的最小堆的非叶子节点

        for(int i = beginIndex; i >=0; i--) {
            heapify(arr, i, heapLen);
        }


        // 遍历K后面的元素，与堆的root元素比较，如果大于最小堆的最小值，则交换
        // 后续在堆化数据，使堆满足最小堆的特性

        for(int j = k; j < arr.length; j++) {
            if (arr[0] < arr[j]) {
                swap(arr, 0, j);
                heapify(arr, 0, heapLen);
            }
        }

    }

    private void heapify(int[] arr, int index, int len) {


        int left = index * 2 + 1;

        int right = left + 1;

        if (left > len) return;

        int min = left;

        if (right <= len && arr[right] < arr[left])
            min = right;


        if(arr[min] < arr[index]) {
            swap(arr, index, min);
            heapify(arr, min, len);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
