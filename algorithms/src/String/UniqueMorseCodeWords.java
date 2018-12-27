package String;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueMorseCodeWords {

    @Test
    public void test() {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }


    public int uniqueMorseRepresentations(String[] words) {
        String[] source =
                {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> set = new HashSet<>();

        for(String word: words) {

            StringBuffer sb = new StringBuffer();

            for(char c: word.toCharArray()) {
                sb.append(source[c - 'a']);
            }

            if (!set.contains(sb.toString())) set.add(sb.toString());
        }

        return set.size();
    }
}
