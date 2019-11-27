package arrayandstring;

import org.junit.Test;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >=0 || j >=0) {

            int v1 = i >= 0 ? (a.charAt(i) - 48) : 0;
            int v2 = j >= 0 ? (b.charAt(j) - 48) : 0;

            int res =  v1 + v2 + carry;
            sb.append(res % 2);
            carry = res / 2;

            i--;
            j--;
        }

        if (carry == 1) sb.append(1);

        return sb.reverse().toString();
    }

    @Test
    public void test() {
        String a = "0";
        String b = "1";
        System.out.println(addBinary(a, b));
    }
}
