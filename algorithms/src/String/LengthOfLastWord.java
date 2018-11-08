package String;

import org.junit.Test;

/**
 * 找出最后一个单词，是以空格分离的。
 */
public class LengthOfLastWord {

    @Test
    public void test() {
        System.out.println(lengthOfLastWord("Hello "));
    }

    public int lengthOfLastWord(String s) {
        int res = 0,  len = s.length(), i = len - 1;

        for (; i >=0 && s.charAt(i) == ' '; i--);
        for (; i >=0 && s.charAt(i) != ' '; i-- ) res ++;
        return res;
    }
}
