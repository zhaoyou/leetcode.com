package interviewEasy.Array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    @Test
    public void test() {
        int nums[] = {2, 7, 11, 15};
        int target = 22;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            int s = target - nums[i];
            if (map.containsKey(s)) {
                return new int[]{map.get(s), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
