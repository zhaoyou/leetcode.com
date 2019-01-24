package hashtable;

import org.junit.Test;

import java.util.Arrays;

public class SetMismatch {

    @Test
    public void test() {
        int[] nums = {1, 2, 2};

        System.out.println(Arrays.toString(findErrorNums2(nums)));
    }

    /**
     * reference: https://leetcode.com/problems/set-mismatch/discuss/105507/Java-O(n)-Time-O(1)-Space
     * @param nums
     * @return
     */
    public int[] findErrorNums2(int[] nums) {


        int[] res = new int[2];
        for(int i :nums) {
            if (nums[Math.abs(i) - 1] < 0) res[0] = Math.abs(i);
            else nums[Math.abs(i) - 1] *= -1;
        }

        for(int i = 0; i<nums.length;i++) {
            if (nums[i] > 0) res[1] = i + 1;
        }
       return res;
    }



    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] map = new int[len + 1];
        int total = len * (len + 1) / 2;
        int[] result = new int[2];
        for(int num: nums) {
            if (map[num] == 1) {
                result[0] = num;
            } else {
                map[num] = 1;
                total -= num;
            }
        }
        result[1] = total;
        return result;
    }
}
