package interviewEasy.Array;

import org.junit.Test;

import java.util.Arrays;

public class MoveZeroes {


    @Test
    public void test() {
        int nums[] = {0, 2, 0, 1, 0, 0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {

        int len = nums.length;
        int a = 0; // zero index;
        int b = 0; // non-zero index;

        while(a < len && b < len) {
            while(a < len && nums[a] != 0 ) a++;
            while(b < len && nums[b] == 0 ) b++;

            if (a < len && b < len) {
                if (b > a) {
                    int temp = nums[a];
                    nums[a] = nums[b];
                    nums[b] = temp;
                } else {
                    b = a;
                }
            }
        }

    }

    private void forward(int[] nums, int i) {
        for(int k = i; k < nums.length - 1; k++) {
            nums[k] = nums[k + 1];
        }
    }
}
