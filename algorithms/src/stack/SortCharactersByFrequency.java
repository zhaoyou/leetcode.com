package stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {

    @Test
    public void test() {
        String s = "cccaaa";
        System.out.println(frequencySort(s));
    }


    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        List<Character>[] bucket = new List[s.length() + 1];

        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c: map.keySet()) {
            if (bucket[map.get(c)] == null) {
                bucket[map.get(c)] = new ArrayList<>();
            }
            bucket[map.get(c)].add(c);
        }

        StringBuffer sb = new StringBuffer();

        for(int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for(char c: bucket[i]) {
                    sb.append(repeat(c, i));
                }
            }
        }

        return sb.toString();
    }

    private String repeat(char c, int count) {
        StringBuffer sb= new StringBuffer();
        while(count > 0) {
            sb.append(c);
            count--;
        }
        return sb.toString();
    }
}
