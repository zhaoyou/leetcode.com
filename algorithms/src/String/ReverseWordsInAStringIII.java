package String;


import org.junit.Test;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 *
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsInAStringIII {

    @Test
    public void test() {
        String input = " to reverse the order of characters";
        System.out.println(input + " -> " + reverseWords(input));
    }

    public String reverseWords(String s) {
        int len = s.length();
        char[] source = s.toCharArray();

        int start = -1;

        for(int i = 0; i < len; i++) {


            if (source[i] != ' ' && start == -1) start = i;

            while(i < len && source[i] != ' ') i++;


            swap(source, start, i - 1);

            start = -1;

        }

        return new String(source);
    }

    private void swap(char[] source, int start, int end) {
        while(start < end) {
            char temp = source[start];
            source[start] = source[end];
            source[end] = temp;
            end--;
            start++;
        }
    }
}
