package String;

import org.junit.Test;

public class DetectCapital {

    @Test
    public void test() {
        String word = "USA";
        word = "FlaG";
        word = "AaaaAlll";
        word = "aabb";
        System.out.println(word + " -> " + detectCapitalUse(word));
    }

    public boolean detectCapitalUse(String word) {


        boolean firstCapital = false;

        int lowerCount = 0;

        int upperCount = 0;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                if (i == 0) firstCapital = true;
                upperCount ++;

                if (lowerCount > 0 && firstCapital) return false;

            } else if (c >= 'a' && c <= 'z') {
                lowerCount ++;
            }
        }

        if (upperCount == word.length()) return true;

        if (lowerCount == word.length()) return true;

        if (firstCapital && lowerCount == word.length() - 1) return true;


        return false;
    }
}
