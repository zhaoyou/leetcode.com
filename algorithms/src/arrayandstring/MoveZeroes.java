package arrayandstring;

import org.junit.Test;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {

        int j = 0;

        for(int i = 0; i < nums.length; i ++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
                if (i != j -1) nums[i] = 0;
            } else {
                while(i < nums.length && nums[i] == 0) i++;
                if (i == nums.length) break;
                nums[j++] = nums[i];
                nums[i] = 0;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes2(int[] nums) {

        int j = 0;
        for(int i = 0; i < nums.length; i ++) {
            if (nums[i] != 0) nums[j++] = nums[i];
        }

        for(; j < nums.length; j++) {
            nums[j] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test() {
        int[] nums = {7,1,5,2,3,4,0};
        moveZeroes2(nums);
    }


}
