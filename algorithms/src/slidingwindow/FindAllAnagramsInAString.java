package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {


    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();

        if (s.length() < p.length()) return list;

        Map<Character, Integer> map = new HashMap<>();

        for(char c: p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0));
        }

        int len = map.size();
        int sLen = s.length();
        int count = len;

        int left = 0, right = 0;

        while(right < sLen) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {

                map.put(c, map.getOrDefault(c, 0) - 1);
                if (map.get(s.charAt(right)) == 0) count--;
            }

            right++;

            while(count == 0) {

                char temp = s.charAt(left);

                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);

                    if (map.get(temp) > 0) {
                        count++;
                    }
                }

                if (right - left == len) {
                    list.add(left);
                }

                left++;
            } 
        }

        return list;
    }
    
}
