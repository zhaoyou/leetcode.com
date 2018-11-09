package String;

public class AddBinary {


    public static void main(String[] args) {
//        System.out.println((int)'0');
//        System.out.println((int)'1');

        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));

    }

    public static  String addBinary(String a, String b) {

        int i = a.length() - 1, j = b.length() - 1;

        int mod = 0;

        StringBuffer sb = new StringBuffer();

        while(i >=0 || j >=0) {

            int i1 = i >= 0 ? (int)a.charAt(i) - 48 : 0;
            int i2 = j >= 0 ? (int)b.charAt(j) - 48 : 0;


            sb.append((i1 + i2 + mod ) % 2);
            mod = (i1 + i2 + mod ) / 2;

            i--;
            j--;
        }

        if (mod == 1) sb.append("1");

        return sb.reverse().toString();
    }
}
