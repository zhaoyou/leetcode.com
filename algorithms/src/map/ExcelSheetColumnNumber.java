package map;

import org.junit.Test;

public class ExcelSheetColumnNumber {

    @Test
    public void test() {
        String s = "ZY";
        System.out.println(titleToNumber(s));
    }

    public int titleToNumber(String s) {
        int len  = s.length();
        int res = 0;
        for(int i = 0; i < len; i++) {
            res += Math.pow(26, len - i - 1) * (s.charAt(i) - 'A' + 1);
        }
        return res;
    }
}
