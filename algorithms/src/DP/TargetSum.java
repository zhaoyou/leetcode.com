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


}
