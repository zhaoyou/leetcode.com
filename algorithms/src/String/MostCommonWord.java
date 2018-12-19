package String;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 *
 *
 * Example:
 *
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 *
 */
public class MostCommonWord {


    @Test
    public void test() {
        String paragraph = "Bob. ,hIt, baLl";
        String[] banned = {"bob", "hit"};
        System.out.println(mostCommonWord(paragraph, banned));
    }

    public String mostCommonWord(String paragraph, String[] banned) {

        Map<String, String> map = new HashMap<>();

        for(String s: banned) { map.put(s, s); }

        Map<String, Integer> m = new HashMap<>();

        char[] source = paragraph.toCharArray();

        String s = "";

        for(int i = 0; i < source.length; i++) {

            boolean isPhontic = (source[i] >= 'a' && source[i] <= 'z') || (source[i] >= 'A' && source[i] <= 'Z');

            //System.out.println(source[i] + ": " + isPhontic);

            if (isPhontic) {
                s += Character.toLowerCase(source[i]);
            } else {
                //System.out.println("s: " + s);
                if (!"".equals(s) && !map.containsKey(s)) m.put(s, m.getOrDefault(s, 0) + 1);
                s = "";
            }
        }

        if (!"".equals(s)) m.put(s, m.getOrDefault(s, 0) + 1);

        int max = 0; String result  = "";

        for(String key: m.keySet()) {
            if (m.get(key) > max) {
                max = m.get(key);
                result = key;
            }
        }

        return result;
    }
}
