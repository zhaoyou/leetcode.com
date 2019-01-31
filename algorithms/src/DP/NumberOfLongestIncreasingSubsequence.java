package DP;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * reference:
 * https://blog.csdn.net/feifeiiong/article/details/77925635
 * http://www.cnblogs.com/grandyang/p/7603903.html
 */
public class NumberOfLongestIncreasingSubsequence {


    @Test
    public void test() {
        int[] nums = {1,1,1,1};
        System.out.println(findNumberOfLIS(nums));
    }


    public int findNumberOfLIS(int[] nums) {

        int len = nums.length;
        int[] dp = new int[nums.length];
        int[] nc = new int[nums.length]; // 记录到已i为结束字符是，最长序列的个数

        Arrays.fill(dp, 1);
        Arrays.fill(nc, 1);

        Map<Integer , Integer>  map = new HashMap<>();

        int res = 0;

        for(int i = 0 ; i < len; i++) {
            for(int j = 0 ; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        nc[i] = nc[j];
                    } else if (dp[i] == dp[j] + 1) {
                        nc[i] += nc[j];
                    }
                }

            }

            res = Math.max(res, dp[i]);
        }

        int result = 0;

        for(int i = 0; i < nc.length; i++) if (dp[i] == res) result += nc[i];


        return result;
    }
}
