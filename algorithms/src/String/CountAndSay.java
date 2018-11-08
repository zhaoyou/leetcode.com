package String;

import org.junit.Test;

public class CountAndSay {


    @Test
    public void test() {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));
        System.out.println(countAndSay(8));
        System.out.println(countAndSay(9));
        System.out.println(countAndSay(10));
    }

    public String countAndSay(int n) {

        if (n == 1) return "1";
        if (n == 2) return "11";

        String res = "11";

        for(int j = 2; j < n; j++) {

            int count = 0;
            char c = res.charAt(0);
            StringBuffer sb = new StringBuffer("");

            for(int i = 0; i < res.length(); i++) {

                if (res.charAt(i) == c) {
                    count ++;
                } else {
                    sb.append(count + "" + c);
                    c = res.charAt(i);
                    count = 1;
                }
            }

            sb.append(count + "" + c);

            res = sb.toString();
        }

        return res;
    }
}
