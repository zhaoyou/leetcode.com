package interviewMedium.ArrayAndString;

import org.junit.Test;

import java.util.*;

public class GroupAnagrams {

    @Test
    public void test() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> list = new ArrayList<>();

        if (strs == null || strs.length == 0) return list;

        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);

            List<String> sub = map.getOrDefault(key, new ArrayList<>());
            sub.add(str);
            map.put(key, sub);

        }

        return new ArrayList<>(map.values());
    }

}
