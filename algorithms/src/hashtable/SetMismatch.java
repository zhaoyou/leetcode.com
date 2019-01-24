package hashtable;

import org.junit.Test;

import java.util.Arrays;

public class SetMismatch {

    @Test
    public void test() {
        int [] nums = {2, 2};

        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] map = new int[len + 1];
        int total = len * (len + 1) / 2;
        int[] result = new int[2];
        for(int num: nums) {
            if (map[num] == 1) {
                result[0] = num;
            } else {
                map[num] = 1;
                total -= num;
            }
        }
        result[1] = total;
        return result;
    }
}
