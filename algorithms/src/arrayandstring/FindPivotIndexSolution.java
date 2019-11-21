package arrayandstring;

import org.junit.Assert;
import org.junit.Test;

public class FindPivotIndexSolution {

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length < 3) return -1;

        int len = nums.length;

        int dp[] = new int[len];
        dp[0] = nums[0];

        for(int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }


        for(int j = 0; j < len; j++) {
            int left = (j == 0) ? 0 : dp[j - 1];      // 处理左边界的问题
            if (left == dp[len - 1] - dp[j]) return j;  // 左边部分 == 右边部分
        }

        return -1;
    }

    public int pivotIndex2(int[] nums) {
        int left = 0, sum = 0;
        for(int num: nums) sum += num;

        for(int i = 0; i < nums.length; i++) {
            if (left == (sum - left - nums[i])) return i;
            left += nums[i];
        }
        return -1;
    }

    @Test
    public void test() {
        Assert.assertEquals(pivotIndex2(new int[]{1, 7, 3, 6, 5, 6}), 3);
        Assert.assertEquals(pivotIndex2(new int[]{1, 2, 3}), -1);
        Assert.assertEquals(pivotIndex2(new int[]{-1,-1,-1,0,1,1}), 0);
    }
}
