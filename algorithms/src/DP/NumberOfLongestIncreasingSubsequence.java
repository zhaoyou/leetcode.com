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
        int[] nums = {1,3,5,4,7};
        System.out.println(findNumberOfLIS(nums));
        System.out.println(findNumberOfLIS2(nums));

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

    public int findNumberOfLIS2(int[] nums) {

        int n = nums.length;

        int len[] = new int[n], cnt[] = new int[n];

        int res = 0, max_len = 0;

        for(int i = 0; i < n; i++) {

            len[i] = cnt[i] = 1;

            for(int j = 0 ; j < i; j++) {

                if (nums[i] > nums[j]) {

                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (len[j] + 1 == len[i]) {
                        cnt[i] = cnt[i] + cnt[j];
                    }

                }
            }

            if (len[i] == max_len) res += cnt[i];
            else if (len[i] > max_len) {
                max_len = len[i];
                res = Math.max(res, cnt[i]);
            }

        }

        return res;
    }

}
