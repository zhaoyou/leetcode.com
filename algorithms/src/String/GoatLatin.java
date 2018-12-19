package String;

import org.junit.Test;

/**
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 *
 * The rules of Goat Latin are as follows:
 *
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 *
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 *
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 *
 *
 *
 * Example 1:
 *
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 *
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 *
 */
public class GoatLatin {


    @Test
    public void test() {
        String S = "tt gx";
        System.out.println(toGoatLatin(S));
    }



    public String toGoatLatin(String S) {
        String[] source = S.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int k = 0; k < source.length; k++) {
            char c = source[k].charAt(0);
            String space = k == source.length - 1 ? "" : " ";
            if (isVowel(c)) {
                sb.append(source[k] + "ma" + repeatA( k + 1) + space);
            } else {
                sb.append(source[k].substring(1) + c + "ma" + repeatA(k + 1) + space);
            }
        }

        return sb.toString();
    }


    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return (c == 'a' || c == 'o' || c == 'e' || c == 'i' || c == 'u');
    }

    private String repeatA(int i) {
        int j = 0;
        StringBuffer sb = new StringBuffer();
        while (j++ < i) { sb.append("a");}
        return sb.toString();
    }
}
