package Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestConsecutiveSequence {

    @Test
    public void test() {
        List<String> userNames = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int num: nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num- 1, 0);
                int right = map.getOrDefault(num + 1, 0);

                int sum = left + right + 1;

                res = Math.max(res, sum);

                map.put(num, sum);


                map.put(num - left, sum);
                map.put(num + right, sum);
            }
        }
        return res;
    }
}
