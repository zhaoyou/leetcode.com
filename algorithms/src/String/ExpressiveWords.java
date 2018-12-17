package String;

import org.junit.Test;


/**
 * reference: https://leetcode.com/problems/expressive-words/discuss/122660/C++JavaPython-2-Pointers-and-4-pointers
 */
public class ExpressiveWords {


    @Test
    public void test() {
        String S = "heeellooo";
        String[] words = {"hello", "hi", "helo"};
        System.out.println(S + " -> expressiveWords: " + expressiveWords(S, words));
    }

    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for(String W: words) if (check(S, W)) res++;
        return res;
    }

    private boolean check(String S, String W) {

        int n = S.length(), m = W.length(), j = 0;

        for(int i = 0; i < n; i++) {

            if (j < m && S.charAt(i) == W.charAt(j)) j++;
            else if (i > 1 && S.charAt(i) == S.charAt(i - 1) && S.charAt(i - 1) == S.charAt(i - 2));
            else if (i > 0 && i < (n - 1) && S.charAt(i) == S.charAt(i - 1) && S.charAt(i) == S.charAt(i + 1));
            else return false;

        }
        return m == j;
    }
}
