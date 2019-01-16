package DP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //Arrays.sort(nums);
        permuteHelper(list, new ArrayList<>(), nums);
        return list;
    }

    private void permuteHelper(List<List<Integer>> list, List<Integer> chosen, int[]nums) {
        if (chosen.size() == nums.length) list.add(new ArrayList<>(chosen));
        else {
            for(int i = 0; i < nums.length; i++) {
                if (chosen.contains(nums[i])) continue;
                chosen.add(nums[i]);
                permuteHelper(list, chosen, nums);
                chosen.remove(chosen.size() - 1);
            }
        }
    }
}
