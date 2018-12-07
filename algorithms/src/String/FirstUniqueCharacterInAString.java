package String;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {


    @Test
    public void test() {
        String s = "leetcode";
        System.out.println(s + " findUniqChar: " + firstUniqChar(s));

    }

    public int firstUniqChar(String s) {

        if (s.length() == 0) return -1;

        if (s.length() == 1) return 0;

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 97;
            System.out.println("index: " + i + " c: " + c + " char: " + s.charAt(i));
            if (arr[c] != 0)  arr[c] = -1; // 如果之前有过则设置为无效，代表有重复的
            else arr[c] = i + 1;  // 代表第一次出现，记录索引。
        }

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 97;
            if (arr[c] != 0 && arr[c] != -1) return arr[c] - 1;
        }

        return -1;
    }
}
