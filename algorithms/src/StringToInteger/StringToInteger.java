package StringToInteger;

import org.junit.Test;

/**
 * Created by zhaoyou on 06/03/2017.
 */
public class StringToInteger {

    public int myAtoi(String str) {
        if (str == null) { return 0;}
        String filterSpaceStr = str.trim();
        int len = filterSpaceStr.length();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < len; i++) {
            char c = filterSpaceStr.charAt(i);
            if (i == 0 && (c == '-' || c == '+' )){sb.append(c);continue;}

            if (c == '-' || c == '+' ||  c > 57 || c < 48) {
                break;
            }

            sb.append(c);
            if (sb.length() > 11) { break;}
        }

        if (sb.length() == 0) { return 0;}

        try {
            Double d =  Double.parseDouble(sb.toString());
            if (d >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (d <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            return d.intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    @Test
    public void test() {
        System.out.println(myAtoi("1234567890123456789012345678901234567890"));
    }
}
