package recursion;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new LinkedList<>();


        list.add(new LinkedList<>());

        for (int num: nums) {

            List<List<Integer>> subList = new LinkedList<>();

           for(List<Integer> l: list) {
               subList.add(new LinkedList<>(l));
               l.add(num);
               subList.add(new LinkedList(l));
           }
            list = subList;
        }

        return list;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
