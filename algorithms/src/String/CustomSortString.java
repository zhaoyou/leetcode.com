package String;

import org.junit.Test;

/**
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
 *
 * S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.
 *
 * Return any permutation of T (as a string) that satisfies this property.
 *
 * Example :
 * Input:
 * S = "cba"
 * T = "abcd"
 * Output: "cbad"
 * Explanation:
 * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
 * Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
 *
 *
 * Note:
 *
 * S has length at most 26, and no character is repeated in S.
 * T has length at most 200.
 * S and T consist of lowercase letters only.
 */
public class CustomSortString {


    @Test
    public void test() {
        String S = "cba";
        String T = "abcd";

        System.out.println("\nS: " + S + "\nT: " + T + "\nOrder: " + customSortString(S, T));
    }

    public String customSortString(String S, String T) {

        if (S.equals("")) return T;

        int[] dp = new int[26];

        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            dp[c - 'a'] = i + 1;
        }

        char[] target = T.toCharArray();
        for (int j = 1; j < T.length(); j++) {

            if (dp[target[j] - 'a'] == 0) continue;

            int k = j ;



            while (k >= 1) {
                
                if (dp[target[k - 1] - 'a'] == 0 || dp[target[k] - 'a'] < dp[target[k - 1] - 'a']) {

                    //System.out.println("swap..");
                    char temp = target[k];
                    target[k] = target[k - 1];
                    target[k - 1] = temp;
                } else {
                    break;
                }

                k--;
            }
        }

        return new String(target);
    }
}
