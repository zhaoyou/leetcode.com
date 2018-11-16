package String;

import org.junit.Test;

public class NumberOfSegmentsInAString {


    @Test
    public void test() {
        String s = " Hello ,  my   name is John";
        //s = "";

        System.out.println(s + " => countSegments: " + countSegments(s));
    }

    public int countSegments(String s) {

        if (s == null || "".equals(s.trim())) return 0;

        s = s.trim();

        if ("".equals(s)) return 0;

        return s.split(" +").length;
    }

    public int countSegments2(String s) {


        int len = s.length();
        int res = 0;

        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c == ' ') continue;
                res ++;

            while(i < len && s.charAt(i) != ' ' ) i++;
        }

        return res;
    }
}
