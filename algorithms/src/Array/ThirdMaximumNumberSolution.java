package Array;

import org.junit.Test;

public class ThirdMaximumNumberSolution {
    public int thirdMax(int[] nums) {
        int secondMax = -1;
        int thirdMax = -1;

        int max = nums[0];

        for(int i = 1; i < nums.length; i++) {

            if (nums[i] > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = nums[i];
            } else if (nums[i] < max && (secondMax == -1 || nums[i] > secondMax)) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if ((secondMax != -1 && nums[i] < secondMax) && (thirdMax == -1 || nums[i] > thirdMax)) {
                thirdMax = nums[i];
            }
        }
        return thirdMax == -1 ? max : thirdMax;
    }

    @Test
    public void test() {
        int[] arr = {3,2,2};
        System.out.println(thirdMax(arr));
    }
}
