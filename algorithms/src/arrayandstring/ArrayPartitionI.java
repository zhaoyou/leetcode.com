package arrayandstring;

import org.junit.Test;

import java.util.Arrays;

public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int sum = 0;

        for(int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }


    @Test
    public void test() {
        int[] nums = {1, 4, 2, 3};
        System.out.println(arrayPairSum(nums));
    }
}
