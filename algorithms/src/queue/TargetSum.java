package queue;

import org.junit.Test;

import java.util.List;

/**
 * https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C++-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation
 */
public class TargetSum {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(0, nums,  S);
        return count;
    }

    private void dfs(int index, int[] nums, int s) {
        System.out.println("index: " + index + " s: " + s);
        if (index == nums.length) {
                if (s == 0) {
                    count++;
                }
                return;
        }
        int p = nums[index];
        index++;
        dfs(index, nums, s + p);
        dfs(index, nums, s - p);
    }

    @Test
    public void test() {
        int[] nums = {1,1,1,1,1};
        int S = 3;
        findTargetSumWays(nums, S);
        System.out.println(count);
    }

    public static void main(String[] args) {
        TargetSum t = new TargetSum();
        int[] nums = {1,1,1,1,1};
        int S = 3;
        t.findTargetSumWays(nums, S);
        System.out.println(t.count);
    }
}
