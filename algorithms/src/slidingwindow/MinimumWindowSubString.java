package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {
    public String minWindow(String s, String t) {
        if (s.equals(t)) return t;
        if (t.length() > s.length()) return "";

        Map<Character, Integer> map = new HashMap<>();

        for(Character c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, count = map.size();
        int len = s.length();
        int min_len = Integer.MAX_VALUE;
        String result = "";

        while(right < len) {

            char temp = s.charAt(right);

            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) - 1);

                if (map.get(temp) == 0) {
                    count--;
                }
            }

            right++;

            while (count == 0) {
                char c = s.charAt(left);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);

                    if (map.get(c) > 0) count++;
                }

                if (right - left < min_len) {
                    min_len = right - left;
                    result = s.substring(left, right+1);
                }

                left++;

            }
        }

        return result;
    }
}
