package Sort;

public class QuickSort3 {
    public static void main(String[] args) {
        int []nums = {6, 1, 2, 5, 4, 3, 9, 7, 10, 8};
        sort(nums, 0, nums.length -1);
        display(nums);
    }

    public static void  display(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(" ");

    }

    public static void sort(int[] nums, int start, int end) {


        if (start >= end) return;

        int i = start, j = end;

        System.out.println("start: " + start + " end: " + end);

        int ref = nums[start];

        while(i < j) {

            while(i < j && nums[j] >= ref) {
                j--;
            }

            while (i < j && nums[i] <= ref) {
                i++;
            }

            if (i < j) {
                swap(nums, i, j);
            }
        }

        nums[start] = nums[i];
        nums[i] = ref;


        sort(nums, start, i - 1);
        sort(nums, i + 1, end);

    }

    public static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
