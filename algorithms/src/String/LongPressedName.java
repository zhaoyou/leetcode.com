package String;

import org.junit.Test;

/**
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
 *
 * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 *
 *
 *
 * Example 1:
 *
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 * Example 2:
 *
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 * Example 3:
 *
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 * Example 4:
 *
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 *
 *
 * Note:
 *
 * name.length <= 1000
 * typed.length <= 1000
 * The characters of name and typed are lowercase letters.
 */
public class LongPressedName {

    @Test
    public void test() {
        String name = "abcef";
        String typed = "abbb";
        System.out.println(isLongPressedName(name, typed));
    }


    public boolean isLongPressedName(String name, String typed) {

        if (typed.length() < name.length()) return false;

        int i = 0, j = 0;

        char t = typed.charAt(0);

        int name_len = name.length();
        int typed_len = typed.length();

        while(i < name_len && j < typed_len) {

            if (name.charAt(i) == typed.charAt(j)) {
               t = typed.charAt(j);
               i++;
               j++;
            } else {
               if (typed.charAt(j) != t) return false;
               j++;
            }
        }

        if (i != name_len) return false;
        while(j < typed_len) if (typed.charAt(j++) != name.charAt(name_len - 1)) return false;
        return true;
    }
}
