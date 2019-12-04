package arrayandstring;

import org.junit.Test;

/**
 * reference
 * https://leetcode.com/problems/reverse-words-in-a-string/discuss/47740/In-place-simple-solution
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {

        String[] arr = s.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();

        int start = 0;
        int end = arr.length - 1;

        System.out.println(arr.length);

        while(start < end) {

            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) sb.append(" ");
        }

        return sb.toString();
    }

    /**
     * https://leetcode.com/problems/reverse-words-in-a-string/discuss/47740/In-place-simple-solution
     * @param s
     * @return
     */
    public String reverseWords2(String s) {

        char[] arr = s.toCharArray();

        // 反转整个字符串
        revese(arr, 0, arr.length - 1);
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                if(index != 0) arr[index++] = ' ';
                int j = i;
                while(j < arr.length && arr[j] != ' ') arr[index++] = arr[j++];
                revese(arr, index - (j - i), index - 1);        // 反转单个单词
                i = j;

            }
        }
        return new String(arr).substring(0, index); // 只需要返回已经处理的字符。
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
        String s = "  a good   example   ";
//            System.out.println(s.length());
        System.out.println(reverseWords2(s));
    }
}
