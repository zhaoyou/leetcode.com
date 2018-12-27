package String;

import org.junit.Test;

public class ToLowerCase {


    @Test
    public void test() {
        String str = "Hello Word!";
        System.out.println(toLowerCase(str));
    }

    public String toLowerCase(String str) {

        if ("".equals(str)) return "";

        char[] source = str.toCharArray();

        for(int i = 0; i < source.length; i++) {
            if (source[i] <= 'Z' && source[i] >= 'A') source[i] = (char)(source[i] + 32);
        }

        return new String(source);
    }
}
