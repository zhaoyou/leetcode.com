package recursion;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        helper(new LinkedList<>(), n, k, 1);
        return result;
    }

    private void helper(List<Integer> subList, int n , int k, int i) {

        if (subList.size() == k) {
            result.add(new LinkedList<>(subList));
            return;
        }


        for(int j = i; j <= n; j++) {
            subList.add(j);

            helper(subList, n , k, j+1);

            subList.remove(subList.size() - 1);
        }
    }

    @Test
    public void test() {
        combine(5, 3);
        System.out.println(result.toString());
    }


}
