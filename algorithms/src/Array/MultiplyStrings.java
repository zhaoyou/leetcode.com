package Array;

import org.junit.Test;


/**
 * reference:
 * https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation?page=2
 */
public class MultiplyStrings {


    @Test
    public void test() {
        String num1 = "123";
        String num2 = "456";
        System.out.println(num1 + "*" + num2 + "=" + multiply(num1, num2));
    }



    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) return "0";

        int len1 = num1.length();
        int len2 = num2.length();

        int[] arr = new int[len1 + len2];

        for(int i = len1 - 1; i >= 0; i--) {

            for(int j = len2 - 1; j >= 0; j--) {

                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int p1 = i + j , p2 = i + j + 1;

                int sum = mul + arr[p2];

                arr[p1] += sum / 10;
                arr[p2] = sum % 10;
            }
        }

        StringBuffer sb = new StringBuffer();

        for(int p: arr) {
            if (p == 0 && sb.length() == 0) continue;
            sb.append(p);
        }

        return sb.toString();
    }
}
