package LongestSubstringWithoutRepeatingCharacters;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoyou on 21/02/2017.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 1) { return length;}
        int max = 0;
        for (int i = 0; i < length; i++) {
            java.util.Map<String, String> map = new java.util.HashMap<String, String>();
            String str = s.substring(i, i + 1);
            map.put(str, str);
            for (int j = i + 1; j < length; j++) {
                String str2 = s.substring(j, j + 1);
                if (map.containsKey(str2)) {
                    break;
                } else {
                    map.put(str2, str2);
                }
            }

            if (map.size() > max) { max = map.size();}
        }
        return max;
    }

    @Test
    public void test1() {
        String str = "abcabcbb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";
        System.out.println(str + ": " + lengthOfLongestSubstring(str));
        System.out.println(str2 + ": " + lengthOfLongestSubstring(str2));
        System.out.println(str3 + ": " + lengthOfLongestSubstring(str3));

    }
}
