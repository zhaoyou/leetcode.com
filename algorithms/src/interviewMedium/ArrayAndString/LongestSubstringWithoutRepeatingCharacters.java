package interviewMedium.ArrayAndString;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * reference:
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/779/discuss/1729/11-line-simple-Java-solution-O(n)-with-explanation
 * 另一种方式
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/779/discuss/1812/Share-my-Java-solution-using-HashSet
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

    @Test
    public void test() {
        String s = "abbbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }


    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) return 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int k = 0;
        for(int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                k = Math.max(k, map.get(s.charAt(i)) + 1);
            }

            res = Math.max(res, i - k + 1);  // 计算最长长度

            map.put(s.charAt(i), i); // 重新添加字符的所在位置。

        }
        return res;
    }

}
