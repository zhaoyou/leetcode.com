package DP;

import org.junit.Test;

public class RangeSumQueryImmutable {

//    class NumArray {
//
//        int[][] dp;
//        int[] nums;
//
//        public NumArray(int[] nums) {
//            this.nums = nums;
//            int len = nums.length;
//            dp = new int[len][len];
//
//
//            for(int i = 0; i < len; i++) {
//                for (int j = i; j < len; j++) {
//                    if (j == i) dp[i][j] = nums[i];
//                    else dp[i][j] = dp[i][j - 1] + nums[j];
//                }
//            }
//        }
//
//        public int sumRange(int i, int j) {
//            return  dp[i][j];
//        }
//    }

    class NumArray {

        int[] dp;
        int len;

        public NumArray(int[] nums) {
            len = nums.length;

            if (len == 0) return;

            dp = new int[len];

            dp[0] = nums[0];

            for(int i = 1; i < len; i++) {
                dp[i] = dp[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if (len == 0) return 0;
            return  i == 0 ? dp[j] : dp[j] - dp[i - 1];
        }
    }

    @Test
    public void test() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(0, 2);
        int param_2 = obj.sumRange(2, 5);
        int param_3 = obj.sumRange(0, 5);
        System.out.println(param_1 + "\n" + param_2 + "\n" + param_3);

    }
}
