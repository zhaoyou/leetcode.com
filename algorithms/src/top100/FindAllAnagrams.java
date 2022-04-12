package top100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new LinkedList<>();

        if (p.length() > s.length()) return result;

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(Character c: p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, count = map.size();

        while(right < s.length()) {

            char c = s.charAt(right);

            if (map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) - 1);

                if (map.get(c) == 0) count--;
            }

            right++;

            while (count == 0) {
                char temp = s.charAt(left);

                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);

                    if (map.get(temp) > 0) {
                        count++;
                    }
                }

                if (right - left == p.length()) {
                    result.add(left);
                }

                left++;
            }

        }        
        return result;
    }
}
