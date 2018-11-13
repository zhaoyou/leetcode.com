package String;

import org.junit.Test;

import java.util.*;

public class GroupAnagrams {
    @Test
    public void test() {
        String s = "Group Anagrams";
        s.toCharArray();
        Arrays.sort(s.toCharArray());

        String [] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(arr));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] source = str.toCharArray();
            Arrays.sort(source);
            String newStr =  new String(source);

            if(map.containsKey(newStr)) {
                map.get(newStr).add(str);
            } else {
                List<String> sub = new ArrayList<>();
                sub.add(str);

                map.put(newStr, sub);
            }
        }

        for(List<String> subList: map.values()) {
            list.add(subList);
        }

        return list;
    }
}
