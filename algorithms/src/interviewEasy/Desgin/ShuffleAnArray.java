package interviewEasy.Desgin;

import java.util.Random;

public class ShuffleAnArray {

}

class Solution {

    int nums[];
    Random random;


    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] a = nums.clone();

        for(int i = 1; i < a.length; i++) {
            int j = random.nextInt(i + 1);
            swap(a, i, j);
        }

        return a;
    }

    private void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
