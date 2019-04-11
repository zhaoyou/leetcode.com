package interviewMedium.sortAndsearch;

import java.util.*;

/**
 * reference:
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/799/discuss/81635/3-Java-Solution-using-Array-MaxHeap-TreeMap
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> (
                b.getValue() - a.getValue()
                ));

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            queue.add(entry);
        }

        while(list.size() < k) {
            list.add(queue.poll().getKey());
        }

        return list;
    }
}
