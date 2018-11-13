package String;

import org.junit.Test;

import java.util.*;

/**
 * reference: https://leetcode.com/problems/palindrome-pairs/discuss/79215/easy-to-understand-ac-c-solution-onk2-using-map
 */
public class PalindromePairs {

    @Test
    public void test() {
        String[] words = //{"abcd","dcba","lls","s","sssll"};
         {"bat","tab","cat"};
        System.out.println(palindromePairs2(words));
    }

    /**
     * 穷举法，不满足条件
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> list = new ArrayList<>();

        if (words == null || words.length == 0) return list;

        int len = words.length;


        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    if (isPalindrome(words[i] + words[j])) {
                        list.add(Arrays.asList(i, j));
                    }
                }
            }
        }
        return list;
    }

    public List<List<Integer>> palindromePairs2(String[] words) {

        List<List<Integer>> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        // 获取数组中每一个元素翻转后的值和所在索引位置
        for(int i = 0; i < words.length; i++) {
            map.put(new StringBuffer(words[i]).reverse().toString(), i);
        }


        // 处理 有"" 字符串的情况。 使得  {"",  self}
        if (map.containsKey("")) {
            for(int i = 0; i < words.length; i++) {
                if (isPalindrome(words[i]) && i != map.get("")) {
                    list.add(Arrays.asList(map.get(""), i));  // 不需要重复添加 {"", self} {self, ""}
                }
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {

                String left = words[i].substring(0, j);
                String right = words[i].substring(j);

                if (map.containsKey(left) && isPalindrome(right) && map.get(left) != i) {
                    list.add(Arrays.asList(i, map.get(left)));  // 满足 j = 0 left = "" self = right {self, ""} 的情况
                }

                if (map.containsKey(right) && isPalindrome(left) && map.get(right) != i) {
                    list.add(Arrays.asList(map.get(right), i));
                }

            }
        }

        return list;
    }


    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;

        while(start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
