package queue;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C++-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation
 */
public class TargetSum {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        Map<String, Integer> map = new HashMap<>();
        return dfs(0, nums,  S, map);
    }

    private int dfs(int index, int[] nums, int s, Map<String, Integer> map) {
        String key = index + ":" + s;

        if (map.containsKey(key)) return map.get(key); // 记忆，后续 i+ 1 到  nums.length - 1 到达 s 的可能组合数。

        if (index == nums.length) {
                if (s == 0) {
                    return 1;
                } else {
                    return 0;
                }
        }
        int p = nums[index];
        index++;
        int plus = dfs(index, nums, s + p, map);
        int minus = dfs(index, nums, s - p, map);

        map.put(key, plus + minus);

        return plus + minus;
    }

    @Test
    public void test() {
        int[] nums = {1,1,1,1,1};
        int S = 3;

        System.out.println(findTargetSumWays(nums, S));
    }

    public static void main(String[] args) {
        TargetSum t = new TargetSum();
        int[] nums = {1,1,1,1,1};
        int S = 3;
        t.findTargetSumWays(nums, S);
        System.out.println(t.count);
    }
}
