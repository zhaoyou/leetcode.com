package interviewEasy.String;

import org.junit.Test;

public class ReverseString {

    @Test
    public void test() {
        String s = "hello world";
        System.out.println(reverseString(s));
    }


    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }
}
