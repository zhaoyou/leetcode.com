package DP;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * reference:
 * https://leetcode.com/problems/target-sum/discuss/97333/Java-simple-DFS-with-memorization
 * http://www.cnblogs.com/grandyang/p/6395843.html
 * https://leetcode.com/articles/target-sum/
 */
public class TargetSum {

    @Test
    public void test() {
        int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        int S = 1;
        System.out.println(findTargetSumWays(nums, S));
        System.out.println(findTargetSumWays2(nums, S));
    }

    public int findTargetSumWays(int[] nums, int S) {

        Map<String, Integer> map = new HashMap<>();
        int result = helper(nums, map,0, S, 0);
        return result;
    }

    private int helper(int[] nums, Map<String, Integer> dp, int sum, int target, int index) {

        if (index >= nums.length ) {
            if (sum == target) return 1;
            else return 0;
        }

        String key = index + "->" + sum;

        if (dp.containsKey(key)) return dp.get(key);

        int plus = helper(nums, dp,sum + nums[index], target, index + 1);
        int sub = helper(nums, dp,sum - nums[index], target,index + 1);

        dp.put(key, plus + sub);

        return plus + sub;

    }

    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0 ;

        for(int i: nums) sum += i;

        return ( S > sum || (S + sum ) % 2 == 1) ? 0 : helper(nums, (S + sum) >>> 1);

    }


    /**
     * https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C%2B%2B-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation
     * @param nums
     * @param target
     * @return
     */
    public int helper(int[] nums, int target) {

        int dp[] = new int[target + 1];

        dp[0] = 1;

        for(int num: nums) {
            for(int j = target; j >= num; j--) {
                dp[j] += dp[ j - num];
            }
        }

        return dp[target];
    }


}
