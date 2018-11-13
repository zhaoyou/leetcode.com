package String;


import org.junit.Test;

/**
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 *
 *
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindrome {

    @Test
    public void test() {
        String input = "A man, a plan, a canal: Panama";
        input = "A man, a plan, a canal: Panama";
        input = ".";


        System.out.println(input + "\n" + isPalindrome(input));

        char c = 'c';
//        System.out.println((int)'0');
//        System.out.println((int)'9');
    }

    public boolean isPalindrome(String s) {

        if (s == null || s.equals("") || s.trim().equals("")) return true;

        int i = 0 , end = s.length() - 1;
        while (i <= end) {
            
            char t1 = Character.toLowerCase(s.charAt(i));
            char t2 = Character.toLowerCase(s.charAt(end));


            boolean b1 = isNormal(t1);
            boolean b2 = isNormal(t2);


            if (b1 && b2 )  {
                if (t1 != t2) return false;
                i ++ ;
                end --;

            }

            if (!b1) i++;
            if (!b2) end--;

            if (i >= end) return true;


        }
        return false;
    }

    private boolean isNormal(char c) {
        return  (c >= 'a' && c <= 'z') || ( c >= 'A' && c <= 'Z') || ( (int)c >= 48 && (int)c <= 57);
    }
}
