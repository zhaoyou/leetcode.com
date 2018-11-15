package String;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    @Test
    public void test() {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(ransomNote + "<--" + magazine + " " + canConstruct2(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote == null || "".equals(ransomNote)) return true;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int j = 0; j < ransomNote.length(); j++) {
            char c = ransomNote.charAt(j);


            if (!map.containsKey(c) || map.get(c) == 0) return false;
            map.put(c, map.get(c) - 1);
        }

        return true;
    }


    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
