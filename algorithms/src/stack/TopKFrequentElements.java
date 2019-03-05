package stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * reference:
 * https://leetcode.com/problems/top-k-frequent-elements/discuss/81602/Java-O(n)-Solution-Bucket-Sort
 *
 */
public class TopKFrequentElements {

    @Test
    public void test() {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        List<Integer>[] bucket = new List[nums.length + 1];

        List<Integer> res = new ArrayList<>();


        // 统计每个数字出现的个数。
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 利用桶排序的思想把，相同次数的元素放在一起。（次数即索引）
        for(Integer key: map.keySet()) {
            int frequent = map.get(key);

            if (bucket[frequent] == null) {
                bucket[frequent] = new ArrayList<>();
            }

            bucket[frequent].add(key);


            System.out.println(frequent + "  ---> " + bucket[frequent]);
        }




        for(int n = bucket.length-1; n >=0 & res.size() < k; n--) {
            if (bucket[n] != null) res.addAll(bucket[n]);
        }

        return res;
    }
}
