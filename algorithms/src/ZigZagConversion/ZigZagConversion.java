package ZigZagConversion;

import org.junit.Test;

/**
 * Created by zhaoyou on 27/02/2017.
 */
public class ZigZagConversion {

    /**
     * step = 6
     * 6
     * 4
     * 2
     * 6
     * A  G  M
     * B FH LN
     * CE IK O
     * D  G
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) { return s;}
        int len = s.length();
        int step = (numRows - 1) * 2;   // 首行和末尾行的相邻两个点的差距.
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            int n = 0;                                   // numRows 3,  len = 15 , max(n) = 5
            while (n < (len + 1) / numRows && (i + step * n < len)) {
                sb.append(s.charAt(i + step * n));
                if (i!= 0 && i != numRows - 1) {    // 除了首行和末尾行 ,中间行的每一个点都应该加上漏掉的点.
                    int current = i + step * n;
                    int add = (step - (2 * i));
                    int wo = current + add ;
                    if (current + add < len)
                        sb.append(s.charAt(wo));
                }
                n++;
            }
            //sb.append("\n");
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String s = "abcdefghijklmno";
        System.out.println(s + ": \n" + convert(s, 2));
    }
}
