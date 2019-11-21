package arrayandstring;

import org.junit.Assert;
import org.junit.Test;

public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {

            if (nums.length == 1) return 0;

            int max  = -1;
            int second = -1;
            int max_index = -1;

            for(int i = 0; i < nums.length; i++) {

                if (nums[i] > max) {
                    second = max;
                    max = nums[i];
                    max_index = i;
                } else if (nums[i] > second) {
                    second = nums[i];
                }


            }


            if (max >= second * 2) return max_index;

            return -1;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, dominantIndex(new int[]{3, 6, 1, 0}));
        Assert.assertEquals(-1, dominantIndex(new int[]{1, 2, 3, 4}));
        Assert.assertEquals(1, dominantIndex(new int[]{1, 2}));
        Assert.assertEquals(-1, dominantIndex(new int[]{1, 2, 3}));
        Assert.assertEquals(2, dominantIndex(new int[]{1, 2, 8, 4}));
        Assert.assertEquals(-1, dominantIndex(new int[]{2, 2}));
        Assert.assertEquals(0, dominantIndex(new int[]{1}));
        Assert.assertEquals(-1, dominantIndex(new int[]{1, 1, 1,1,1}));
        Assert.assertEquals(0, dominantIndex(new int[]{2, 1, 1,1,1}));


    }
}
