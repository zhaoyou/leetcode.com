package interviewMedium.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {



    @Test
    public void test() {
        String digits = "456";
        System.out.println(letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {


        List<String> list = new ArrayList<>();

        if (digits == null || digits.length() == 0) return list;

        StringBuffer s = new StringBuffer();
        helper(digits, list, s, 0);
        return list;
    }

    private void helper(String digits, List<String> list, StringBuffer s, int i) {
        if (i == digits.length()) {
            list.add(s.toString());
            return;
        }

        List<String> letters = getByNumber(digits.charAt(i));

        for(int k = 0; k < letters.size(); k++) {
            s.append(letters.get(k));
            helper(digits, list, s, i+1);
            s.delete(s.length() - 1, s.length());
        }
    }

    private List<String> getByNumber(char i) {
        switch (i) {
            case '2': return Arrays.asList("a", "b", "c");
            case '3': return Arrays.asList("d", "e", "f");
            case '4': return Arrays.asList("g", "h", "i");
            case '5': return Arrays.asList("j", "k", "l");
            case '6': return Arrays.asList("m", "n", "o");
            case '7': return Arrays.asList("p", "q", "r", "s");
            case '8': return Arrays.asList("t", "u", "v");
            default:  return Arrays.asList("w", "x", "y", "z");
        }
    }
}
