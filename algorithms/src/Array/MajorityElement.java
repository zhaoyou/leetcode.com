package Array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 * reference:
 * https://leetcode.com/problems/majority-element/discuss/51611/Java-solutions-(sorting-hashmap-moore-voting-bit-manipulation).
 * 多投票算法 Boyer-Moore Algorithm
 * https://blog.csdn.net/kimixuchen/article/details/52787307
 */
public class MajorityElement {

    @Test
    public void test() {
        int [] nums = {3,3,4};
        System.out.println(majorityElement2(nums));
    }

    /**
     *     Arrays.sort(nums);
     *     return nums[nums.length/2];
     * */


    public int majorityElement(int[] nums) {
        if (nums.length <= 2) return nums[0];
        Arrays.sort(nums);
        int count = 1;

        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (++count > nums.length/ 2) return nums[i];
            } else {
                count = 1;
            }
        }
        return 0;
    }

    /**
     * 多投票算法 Boyer-Moore Algorithm
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int count = 0, candidate = 0;
        for(int num: nums) {
            if (count == 0) {
                candidate = num;
                count++;
            } else if (num != candidate) {
                count--;
            } else {
                count++;
            }
        }

        return candidate;
    }
}
