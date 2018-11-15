package String;

import org.junit.Test;

/**
 * reference: http://www.cnblogs.com/grandyang/p/6087347.html
 */
public class RepeatedSubstringPattern {

    @Test
    public void test() {
        String s = "abcabc";
        System.out.println(s + " -> " + repeatedSubstringPattern(s));
    }


    public boolean repeatedSubstringPattern(String s) {

        if (s == null || s.length() == 1) return false;

        int len = s.length();


        for(int i = len / 2; i >= 1; i-- ) {

            if (len % i == 0 && isSame(s.substring(0, i), s)) {
                return true;
            }
        }

        return false;
    }

    private boolean isSame(String sub, String source) {
        int count = source.length() / sub.length();
        StringBuffer sb = new StringBuffer(sub);
        for(int i = 0; i < count - 1; i++) {
            sb.append(sub);
        }
        return sb.toString().equals(source);
    }
}
