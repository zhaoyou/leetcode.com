package DP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
       // Arrays.sort(nums);
        dfs(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void dfs(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {


        list.add(new ArrayList<>(tempList));

        for(int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            dfs(list, tempList, nums, i + 1 );
            tempList.remove(tempList.size() - 1);
        }
    }
}
