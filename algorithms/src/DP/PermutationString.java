package DP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PermutationString {

    @Test
    public void test() {
        System.out.println(permutation("hello"));
    }

    public List<String> permutation(String s) {
        List<String> list = new ArrayList<>();
        // 如果需要保证唯一，需要使用set
        permutationHelper(list, s, "", new boolean[s.length()]);
        return list;
    }

    private void permutationHelper(List<String> list, String s, String chosen, boolean[] used) {

        if (chosen.length() == s.length()) list.add(chosen);

        for(int i = 0; i < s.length(); i++) {
            if (used[i]) continue;
            chosen += s.charAt(i);
            used[i] = true;
            permutationHelper(list, s, chosen, used);
            chosen  = chosen.substring(0, chosen.length() - 1);
            used[i] = false;
           // System.out.println("chosen: " + chosen + " i: " + i);
        }
    }
}
