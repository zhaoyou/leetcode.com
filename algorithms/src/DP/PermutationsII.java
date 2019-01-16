package DP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * reference: https://leetcode.com/problems/permutations-ii/discuss/18594/Really-easy-Java-solution-much-easier-than-the-solutions-with-very-high-vote?page=1
 */
public class PermutationsII {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4};
        System.out.println(permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);

        dfs(list, new ArrayList<>(), nums, used);

        return list;

    }

    private void dfs(List<List<Integer>> list, List<Integer> chosen, int[] nums, boolean[] used) {
        if (nums.length == chosen.size()) {
            list.add(new ArrayList<>(chosen));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if (used[i]) continue;    // 当前使用了
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

                used[i] = true;
                chosen.add(nums[i]);
                dfs(list, chosen, nums, used);
                chosen.remove(chosen.size() - 1);
                used[i] = false;
            }
        }
    }
}
