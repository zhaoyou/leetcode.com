package Sort;

public class SelectionSort {
    public void selectionSort(int[] arr) {
        int min, temp;
        for(int i = 0; i < arr.length; i++) {
            min = i; // 初始化未排序列表的最小值

            for(int j = i + 1; j < arr.length; j++) {
                // 在未排序的列表中，找到最小数的下标保存起来。
                if (arr[j] < arr[min]) min = j;
            }

            // 把最终的最小值放入到已排序列表中最后
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
