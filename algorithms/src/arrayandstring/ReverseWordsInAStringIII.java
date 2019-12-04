package arrayandstring;

import org.junit.Test;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                int j = i;
                while (j < arr.length && arr[j] != ' ') j++;

                revese(arr, i, j - 1);

                i = j;
            }

        }
        return new String(arr);
    }

    private void revese(char[] arr, int start, int end) {
        while(start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    @Test
    public void test() {
        String s = " Let's take LeetCode contest ";
        System.out.println(reverseWords(s));
    }

}
