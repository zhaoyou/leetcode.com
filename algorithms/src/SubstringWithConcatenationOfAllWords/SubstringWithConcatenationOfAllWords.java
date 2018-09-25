package SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://soulmachine.gitbooks.io/algorithm-essentials/content/java/simulation/substring-with-concatenation-of-all-words.html
 */

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String [] words = {"foo","bar"};

        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {


        HashMap<String, Integer> used = new HashMap<>();

        List<Integer> result = new ArrayList<>();

        if (words.length == 0) return result;


        int subLength = words[0].length();

        int allLength = words[0].length() * words.length;

        if (s.isEmpty()) return result;

        if (s.length() < allLength) return result;

        for (String word: words) {
            used.put(word, used.getOrDefault(word, 0) + 1);
        }


        for (int i = 0; i <= s.length() - allLength; i++) {


            HashMap<String, Integer> unused = new HashMap<>(used);

            for (int j = i; j < i + allLength; j+=subLength) {

                String key = s.substring(j, j + subLength);

                int pos = unused.getOrDefault(key, -1);

                if (pos == -1 || pos == 0) break;

                unused.put(key, pos - 1);

                if (pos - 1 == 0) unused.remove(key);
            }

            if (unused.isEmpty()) result.add(i);
        }

        return result;
    }
}
