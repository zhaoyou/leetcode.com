package twopoint;

import org.junit.Test;

public class LongestRepeatingCharacterReplacement {


    @Test
    public void test() {
       String s = "ABBB";
       int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    public int characterReplacement(String s, int k) {

        if (k >= s.length()) return s.length();

        int len = s.length();

        int maxLen = 1;

        for(int i = 0; i < len; i++) {


            int j = i + 1;

            int c = k;

            while(j < len) {
                if (s.charAt(i) != s.charAt(j)) {
                    if (c <= 0) {
                        break;
                    }
                    c--;
                }

                j++;
            }



            System.out.println("j: " + j + " i: " + i);

            maxLen = Math.max(maxLen, j - i);

           // i = j - 1;

        }



        return maxLen;
    }
}
