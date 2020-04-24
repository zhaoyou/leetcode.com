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


    /**
     * 采用bit的方式来计算可能的组合, 先计算出可能的组合掩码组合，然后判断其中位1 的代表需要该位置上的元素。
     * 【1， 2， 3】
     * 0 0 0
     * 0 0 1
     * 0 1 0
     * 0 1 1
     * 1 0 0
     * 1 0 1
     * 1 1 0
     * 1 1 1
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();

        int n = nums.length;

        int nbits = 1 << n;

        for(int i = 0; i < nbits; i++) {

            String bitMask = Integer.toBinaryString(i | nbits).substring(1);


            List<Integer> cur = new LinkedList<>();

            for(int j = 0; j < bitMask.length(); j++) {
                if (bitMask.charAt(j) == '1') cur.add(nums[j]);
            }

            list.add(cur);
        }

        return list;
    }


    @Test
    public void binarytest() {
//        int n = 3;
//        int nthBit = 1 << n;
//        for (int i = 0; i < (int)Math.pow(2, n); ++i) {
//            // generate bitmask, from 0..00 to 1..11
//            String bitmask = Integer.toBinaryString(i | nthBit );//.substring(1);
//            System.out.println(bitmask);
//        }

        int[] nums = {1, 4, 6};
        System.out.println(subsets2(nums));

    }

    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        backtrack(list, new LinkedList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> cur, int[] nums, int index) {



        list.add(new LinkedList<>(cur));

        if (index == nums.length) return;


        for(int i = index; i < nums.length; i++) {

            cur.add(nums[i]);

            backtrack(list, cur, nums, i + 1);

            cur.remove(cur.size() - 1);

        }

    }

    @Test
    public void test3() {
        int[] nums = {1, 2, 3};
        System.out.println(subsets3(nums));
    }

}
