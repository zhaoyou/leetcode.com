package DP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * reference:
 * https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 */
public class SubsetsII {

    @Test
    public void test() {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void dfs(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]);
            dfs(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
