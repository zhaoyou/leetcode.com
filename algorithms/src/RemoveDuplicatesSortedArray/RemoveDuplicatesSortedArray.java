package RemoveDuplicatesSortedArray;

public class RemoveDuplicatesSortedArray {
    public static void main(String[] args) {

//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums = {0,1,2};
        System.out.println(new RemoveDuplicatesSortedArray().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {

        if (nums.length <= 1) return nums.length;

        int index = 0;

        nums[index] = nums[0];


        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }

        return index+1;
    }
}
