package String;


import org.junit.Test;

/**
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 *
 *
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */

/**
 * reference: http://www.cnblogs.com/grandyang/p/6583004.html
 */
public class ReverseStringII {

    @Test
    public void test() {
        String s = "abcdefgh";
        int k = 2;
        System.out.println(s + " -> reverStr: " + reverseStr(s, k));
    }


    public String reverseStr(String s, int k) {
        int len = s.length();

        if (k == 1) return s;

        char[] source = s.toCharArray();

        int i = 0;

        while (i < len) {

            int end = i + k;

            if (i + k > len) {
                end = len - 1;
            } else {
                end = end - 1;
            }

            swap(source, i, end);

            i = i + 2 * k;
        }
        return new String(source);
    }

    private  void swap(char[] source, int start, int end) {
        while(start < end) {
            char temp = source[start];
            source[start] = source[end];
            source[end] = temp;

            start++;
            end--;
        }
    }
}
