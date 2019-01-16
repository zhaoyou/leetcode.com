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
        permutationHelper(list, s, "", 0);
        return list;
    }

    private void permutationHelper(List<String> list, String s, String chosen, int index) {

        if (chosen.length() == s.length()) list.add(chosen);

        for(int i = index; i < s.length(); i++) {
            chosen += s.charAt(i);
            permutationHelper(list, s, chosen, i + 1);
            chosen  = chosen.substring(0, chosen.length() - 1);
            System.out.println("chosen: " + chosen + " i: " + i);
        }
    }
}
