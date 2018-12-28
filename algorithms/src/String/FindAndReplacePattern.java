package String;

import java.util.LinkedList;
import java.util.List;

/**
 * reference:
 * https://leetcode.com/problems/find-and-replace-pattern/discuss/161266/JAVA-3ms-Clear-Code
 *
 *  关键部分，定义数组，只要之前出现的字符索引不相等，就意味着之前出现了当前的字符。所以模式就肯定不匹配
 */
public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new LinkedList<>();
        for(String word: words) {
            int[] s = new int[26];
            int[] p = new int[26];
            boolean isMatch = true;
            for(int i = 0; i < word.length(); i++) {
                if (s[word.charAt(i) - 'a'] != p[pattern.charAt(i) - 'a']) {
                    isMatch = false;
                    break;
                } else {
                    s[word.charAt(i) - 'a'] = p[pattern.charAt(i) - 'a'] = i + 1;
                }
            }
            if (isMatch) res.add(word);
        }

        return res;
    }
}
