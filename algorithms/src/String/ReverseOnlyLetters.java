package String;

import org.junit.Test;

public class ReverseOnlyLetters {

    @Test
    public void test() {
        String S = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(S));
    }


    public String reverseOnlyLetters(String S) {
        char[] source = S.toCharArray();

        int i = 0, j = source.length - 1;

        while(i < j) {
            while (!Character.isLetter(source[i]) && i < j) {i++;}
            while(!Character.isLetter(source[j]) && i < j) { j--;}

            if (i < j) {
                char temp = source[i];
                source[i] = source[j];
                source[j] = temp;
            }

            i++;
            j--;
        }
        return new String(source);
    }
}
