package heap;

import org.junit.Test;

import java.util.*;

public class TopKFrequentWords {

    @Test
    public void test() {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        System.out.println(topKFrequent(words, k));
    }

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for(String str: words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }


        PriorityQueue<Map.Entry> queue = new PriorityQueue<Map.Entry>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {

                Map.Entry<String, Integer> entry1 = (Map.Entry)o1;
                Map.Entry<String, Integer> entry2 = (Map.Entry)o2;

                if (entry1.getValue().intValue() == entry2.getValue().intValue())
                    return entry1.getKey().compareTo(entry2.getKey());
                else {
                    return entry2.getValue() - entry1.getValue();
                }
            }
        });


        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            queue.add(entry);
        }

        List<String> list = new ArrayList<>();


        while(k > 0) {
            list.add(queue.poll().getKey().toString());
            k--;
        }

        return list;
    }
}
