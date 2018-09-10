package LetterCombinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinations {
    public static void main(String[] args) {
        String digits = "579";
        List<String> result = letterCombinations(digits);
        System.out.println(result);

    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        for (int i = 0; i < digits.length(); i++) {
            List<String> temp = new ArrayList();
            List<String> asiccStr = getNumberMapString(digits.charAt(i));
            if (result.isEmpty()) {
                for(int k = 0; k < asiccStr.size(); k++)
                    temp.add(asiccStr.get(k));
            } else {
                for(int j = 0; j < result.size(); j++) {
                    for(int k = 0; k < asiccStr.size(); k++)
                        temp.add(result.get(j) + asiccStr.get(k));
                }
            }

            result.clear();
            result.addAll(temp);
        }

        return result;
    }

    public static List<String> getNumberMapString(char number) {
        switch(number) {
            case '2':
                return Arrays.asList("a", "b", "c");
            case '3':
                return Arrays.asList("d", "e", "f");
            case '4':
                return Arrays.asList("g", "h", "i");
            case '5':
                return Arrays.asList("j", "k", "l");
            case '6':
                return Arrays.asList("m", "n", "o");
            case '7':
                return Arrays.asList("p", "q", "r", "s");
            case '8':
                return Arrays.asList("t", "u", "v");
            case '9':
                return Arrays.asList("w", "x", "y", "z"); 
            default: break;

        }
        return null;
    }
}