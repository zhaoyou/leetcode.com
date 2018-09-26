package Sort;

public class MergeSort2 {
    public static void main(String[] args) {
        int []nums = {6, 1, 2, };//5, 4, 3, 9, 7, 10, 8};
        int[] result = new int[nums.length];
        display(nums);
        merge_sort(nums, result, 0, nums.length -1);
        display(nums);
    }

    public static void  display(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(" ");

    }

    public static void merge_sort(int[] arr, int[] result, int start, int end) {
        if (start >= end) return;

        int mid =  start + ((end - start) / 2);

        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;

        merge_sort(arr, result, start1, end1);
        merge_sort(arr, result, start2, end2);

        int k = start;

        while(start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] > arr[start2] ? arr[start2++] : arr[start1++];
        }

        while(start1 <= end1) { result[k++] = arr[start1++]; }

        while(start2 <= end2) { result[k++] = arr[start2++]; }

        for(k = start; k <= end; k++) {
            arr[k] = result[k];
        }
    }
}
