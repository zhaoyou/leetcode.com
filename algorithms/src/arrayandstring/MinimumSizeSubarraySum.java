package arrayandstring;

import org.junit.Test;

/**
 * reference
 * https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59078/Accepted-clean-Java-O(n)-solution-(two-pointers)
 */
public class MinimumSizeSubarraySum {

    /**
     * Input: s = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {


        int j = 0;

        int MIN = Integer.MAX_VALUE;

        int SUM = 0;

        for(int i = 0; i < nums.length; i++) {

            SUM += nums[i];

            while(SUM >= s) {
                MIN = Math.min(MIN, i - j + 1);
                SUM -= nums[j++];
            }
        }

        return MIN == Integer.MAX_VALUE ? 0 : MIN;
    }


    public int minSubArrayLen2(int s, int[] nums) {

        if (nums.length == 0) return 0;

        int dp[] = new int[nums.length];
        dp[0] = nums[0];

        int MIN = Integer.MAX_VALUE;

        for(int i = 1; i < nums.length; i++) {
            dp[i] += dp[i - 1] + nums[i];
        }


        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                int sum = dp[j] - dp[i] + nums[i];

                if (sum >= s) {
                    MIN = Math.min(MIN, j - i + 1);
                    break;
                }
            }
        }

        return MIN == Integer.MAX_VALUE ? 0 : MIN;
    }

        @Test
    public void test() {
        int[] nums = {1, 4, 4};
        System.out.println(minSubArrayLen(4, nums));
    }
}
