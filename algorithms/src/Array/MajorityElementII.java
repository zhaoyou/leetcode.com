package Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 *
 * reference:
 * https://leetcode.com/problems/majority-element-ii/discuss/174987/topic?page=4
 *
 */
public class MajorityElementII {

    @Test
    public void test() {
        int[] nums = {1,2,3,4,3};
        System.out.println(majorityElement(nums));
    }

    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        int candidateA = 0;
        int candidateB = 0;
        int countA = 0;
        int countB = 0;

        for(int num: nums) {

            if (num == candidateA) {
                countA++;
                continue;
            }

            if (num == candidateB) {
                countB++;
                continue;
            }


            if (countA == 0) {
                candidateA = num;
                countA++;
                continue;
            }


            if (countB == 0) {
                candidateB = num;
                countB++;
                continue;
            }

            countA--;
            countB--;

        }

        int a = 0;
        int b = 0;
        for(int num: nums) {
            if (num == candidateA) a++;
            else if (num == candidateB) b++;
        }

        if (a > nums.length/3) list.add(candidateA);
        if (b > nums.length/3) list.add(candidateB);

        return list;
    }
}
