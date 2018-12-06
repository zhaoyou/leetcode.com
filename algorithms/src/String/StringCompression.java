package String;

import org.junit.Test;

public class StringCompression {


    @Test
    public void test() {
        char[] chars = "abccde".toCharArray();
        System.out.println(compress(chars));
    }

    /**
     * Example 3:
     *
     * Input:
     * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
     *
     * Output:
     * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
     *
     * Explanation:
     * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
     * Notice each digit has it's own entry in the array.
     *
     * @param chars
     * @return
     */

    public int compress(char[] chars) {

        if (chars.length == 1) return 1;

        int len = chars.length;
        int c = 1;
        int index = 1;

        for(int i = 1; i < len; i++) {

            if (chars[i] == chars[i - 1]) {
                c++;
            } else {

                if (c != 1) {
                    for(char obj: String.valueOf(c).toCharArray()) { chars[index++] = obj; }
                }
                chars[index++] = chars[i];
                c = 1;
            }
        }




        if (c != 1) {
            for(char obj: String.valueOf(c).toCharArray()) {
                chars[index++] = obj;
            }
        }

        return index;
    }
}
