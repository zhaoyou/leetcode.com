package binarysearchtree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/discuss/61645/AC-O(N)-solution-in-Java-using-buckets-with-explanation
 * http://zyy1217.com/2016/08/18/leetcode220/
 * https://www.hrwhisper.me/leetcode-contains-duplicate-i-ii-iii/#comment-18761
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (k < 1 || t < 0) return false;

        Map<Long, Long> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            long changeValue = (long)nums[i] - Integer.MIN_VALUE;

            long buck = changeValue / ((long)t + 1);

            if (map.containsKey(buck)
                    || (map.containsKey(buck - 1) && changeValue - map.get(buck - 1) <= t)
                    || (map.containsKey(buck + 1) && map.get(buck + 1) - changeValue <= t) ) {
                return true;
            }

            if (map.size() >= k) {
                map.remove(((long)nums[i - k] - Integer.MIN_VALUE ) / ((long)t + 1));
            }

            map.put(buck, changeValue);
        }

        return false;
    }
}
