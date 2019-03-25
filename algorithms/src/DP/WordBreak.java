package DP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    @Test
    public void test() {
        String s = "catsandog";
        List<String> wordDict = new ArrayList() {{ add("cats"); add("dog"); add("sand"); add("and"); add("cat");}};
        System.out.println(wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, String> map = new HashMap<>();
        for(String str: wordDict) map.put(str, str);


        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for(int i = 1; i <= s.length(); i++) {

            for(int j = 0; j < i; j++) {
                if(dp[j] && map.containsKey(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }


}
