package LongestSubstringWithoutRepeatingCharacters;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoyou on 21/02/2017.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * o(n²) 的复杂度. 需要遍历每一个字符到结束为止的最大不重复字符串长度.
     * @param s
     * @return
     */
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


    /**
     * @link https://discuss.leetcode.com/topic/8232/11-line-simple-java-solution-o-n-with-explanation
     * 定义两个指针left , right. 每次right往右平移,加入到Map中.判断当前的指针是否已经map中,每次记录left-> right 的长度
     * 当right出现map已经存在的,则判断第一次的位置在left指针的左边还是右边.如果在左边在left左边不移动(left指针不回退).
     * 如果出现在left指针的右边,则更新left的坐标到right指针第一次出现的位置的下一位.保证left-right位置都是最长的不重复字符串.
     * 每次都比较 left-> right 的长度.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) { return 0;}
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    @Test
    public void test2() {
        String str = "abcdbwc";
        System.out.println(str + ": " + lengthOfLongestSubstring2(str));
    }


    @Test
    public void test2_2() {
        String str = "abcabcbb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";
        System.out.println(str + ": " + lengthOfLongestSubstring2(str));
        System.out.println(str2 + ": " + lengthOfLongestSubstring2(str2));
        System.out.println(str3 + ": " + lengthOfLongestSubstring2(str3));
    }

    @Test
    public void test2_3() {
        String str = "abcdbwc";
        System.out.println(str + ": " + lengthOfLongestSubstring2(str));
    }

    /**
     * 和第两种的方式,唯一的变化就是,使用int[] 代替 Map.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        if (s.length() == 0) { return 0;}
        int[] cache = new int[256];
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
            cache[s.charAt(i)] = i + 1;
            max = Math.max(max, i -j + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring4(String s) {
        if (s.length() == 0) { return 0;}
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, count = 0, len = s.length();
        int result = 0;
        while(right < len) {
            char temp = s.charAt(right);

            map.put(temp, map.getOrDefault(temp, 0) + 1 );

            if (map.get(temp) > 1) count++;

            right++;

            while(count > 0) {

                char t = s.charAt(left);

                map.put(t, map.get(t) - 1);

                if (map.get(t) > 0) count--;

                left++;
            }

            result = Math.max(result, right - left);
        }

        return result;
    }

    @Test
    public void test3() {
        String str = "abcabcbb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";
        System.out.println(str + ": " + lengthOfLongestSubstring3(str));
        System.out.println(str2 + ": " + lengthOfLongestSubstring3(str2));
        System.out.println(str3 + ": " + lengthOfLongestSubstring3(str3));
    }

}
