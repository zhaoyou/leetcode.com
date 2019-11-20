package binarysearch;

import com.oracle.tools.packager.mac.MacAppBundler;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * reference:
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/discuss/51249/Python-different-solutions-(two-pointer-dictionary-binary-search).
 */
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int len = numbers.length;

        for (int i = 0; i < len; i++) {
            int r = target - numbers[i];
            if (map.containsKey(r)) {
                return new int[] {map.get(r) + 1, i + 1};
            } else {
                map.put(numbers[i], i);
            }
        }

        return null;
    }


    public int[] twoSum2(int[] numbers, int target) {

        if (numbers == null || numbers.length == 1) return null;

        int i = 0, j = numbers.length - 1;

        while(i < j) {
            int sum = numbers[i] + numbers[j];

            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[] {i + 1, j + 1};
            }
        }

        return null;
    }

        @Test
    public void test() {
        int[] numbers = new int[] {2,7,11,15};
        int target = 17;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}
