package IntegerToRoman;


/**
 * @author zhaoyou
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        int[] source = {3, 4, 9, 58, 1994, 3999};
        for (int i = 0; i < source.length; i++) {
            System.out.println(intToRoman(source[i]));
        }
    }


    /**
     * 
        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
     */

     /**
      * 
I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
      */

    public static String intToRoman(int num) {
        StringBuffer result = new StringBuffer("") ;

        if (num == 0) return "";

        if (num >= 1000) {
            int wei = num / 1000;
            result.append(repeatRoman(wei, "M"));
            result.append(intToRoman(num % 1000));
            return result.toString();
        } else if (num >= 500) {
            if (num >= 900) {
                result.append("CM");
                result.append(intToRoman(num - 900));
            } else {
                result.append("D");
                result.append(intToRoman(num % 500));
            }
            return result.toString();
        } else if (num >= 100) {

            if (num >= 400) {
                result.append("CD");
                result.append(intToRoman(num - 400));
            } else {
                result.append(repeatRoman(num / 100, "C"));
                result.append(intToRoman(num % 100));
            }
            return result.toString();
        } else if (num >= 50) {

            if (num >= 90) {
                result.append("XC");
                result.append(intToRoman(num - 90));
            } else {
                result.append("L");
                result.append(intToRoman(num % 50));
            }
            return result.toString();
        } else if (num >= 10) {

            if (num >= 40) {
                result.append("XL");
                result.append(intToRoman(num - 40));
            } else {
                result.append(repeatRoman(num / 10, "X"));
                result.append(intToRoman(num % 10));
            }
            return result.toString();
        } else if (num >= 5) {

            if (num >= 9) {
                result.append("IX");
                result.append(intToRoman(num - 9));
            } else {
                result.append("V");
                result.append(intToRoman(num % 5));
            }            
            return result.toString();
        } else if (num >= 1) {

            if (num >= 4) {
                result.append("IV");
                result.append(intToRoman(num - 4));
            } else {
                result.append(repeatRoman(num / 1, "I"));
            }
            return result.toString();
        }
        
        return result.toString();
    }

    /**
     * 重复单个罗马字符
     */
    public static String repeatRoman(int count, String r) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append(r);
        }
        return sb.toString();
    }
}