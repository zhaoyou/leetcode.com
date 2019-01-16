package DP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {


    @Test
    public void test() {
        System.out.println(partition("abcdede"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), s, 0);
        return list;
    }

    private void dfs(List<List<String>> list, List<String> tempList, String s, int start) {
        if (start == s.length()) list.add(new ArrayList<>(tempList));
        else {
            for(int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start, i + 1));

                    dfs(list, tempList, s, i + 1);

                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
