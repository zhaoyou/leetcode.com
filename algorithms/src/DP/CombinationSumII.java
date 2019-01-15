package DP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {


    @Test
    public void test() {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(Arrays.toString(candidates));
        System.out.println(combinationSum2(candidates, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void dfs(List<List<Integer>> list, ArrayList<Integer> tempList,
                     int[] candidates, int remain, int start) {

        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for(int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                tempList.add(candidates[i]);
                dfs(list, tempList, candidates, remain - candidates[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
