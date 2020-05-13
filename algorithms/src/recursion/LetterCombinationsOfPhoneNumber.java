package recursion;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    char[][] source = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };


    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();

        if (digits == null || "".equals(digits)) return list;

        helper(list, new StringBuilder(""), 0, digits);

        return list;
    }

    private void helper(List<String> list, StringBuilder target, int index, String digits) {

        if (index == digits.length()) {
            list.add(target.toString());
            return;
        }


        char[] data = source[digits.charAt(index) - '2'];

        for(char c: data) {

            target.append(c);

            helper(list, target, index + 1, digits);

            target.delete(target.length() - 1, target.length());

        }

    }

    @Test
    public void test() {
        System.out.println(letterCombinations("23"));
    }
}