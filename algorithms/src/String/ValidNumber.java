package String;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * reference: http://www.cnblogs.com/grandyang/p/4084408.html (牛逼的人）
 * 状态机： https://zhuanlan.zhihu.com/p/20042325
 *
 */
public class ValidNumber {

    @Test
    public void test() {
        System.out.println((int)'0');
        System.out.println((int)'9');
        System.out.println((int)'e');
        System.out.println((int)'E');


    }

    /**
     * "0" => true
     * " 0.1 " => true
     * "abc" => false
     * "1 a" => false
     * "2e10" => true
     * " -90e3   " => true
     * " 1e" => false
     * "e3" => false
     * " 6e-1" => true
     * " 99e2.5 " => false
     * "53.5e93" => true
     * " --6 " => false
     * "-+3" => false
     * "95a54e53" => false
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null || s.trim().equals("") || "00".equals(s)) return false;

        s = s.trim();
        Map<String, Boolean> map = new HashMap<>();

        for(int i = 0; i < s.length();i++) {
            char c = s.charAt(i);

            if (!isSign(c) && !isNum(c) && map.isEmpty()) return false;

            if (isSign(c)) map.put("sign", true);
            if (isNum(c)) {
                map.put("num", true);
            }
        }

        return false;

    }

    private boolean isPoint(char c) {
        return c == '.';
    }

    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }

    private boolean isE(char c) {
        return c == 'e';
    }

    private boolean isZero(char c) {
        return (int)c == 48;
    }

    private boolean isNum(char c) {
        return (int)c >=48 && (int)c <= 49;
    }


}
