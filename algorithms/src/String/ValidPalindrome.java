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

/**
 * reference: http://www.cnblogs.com/grandyang/p/4030114.html (特殊处理字符串大小写）
 *
 * a-z  97 - 122;
 * A-Z  65 - 90;
 *
 * char c = 'x';
 * char C = 'X';
 *  (c + 32 - a ) % 32 == (C + 32 - a) % 32
 */
public class ValidPalindrome {

    @Test
    public void test() {
        String input = "A man, a plan, a canal: Panama";
        input = "A man, a plan, a canal: Panama";
        input = ".";


        System.out.println(input + "\n" + isPalindrome(input));

        char a = 'a';
        char z = 'z';
        char A = 'A';
        char Z = 'Z';
        System.out.println((int)a);
        System.out.println((int)z);
        System.out.println((int)A + " " + ((A + 32 - 'a') %32));
        System.out.println((int)Z);


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

    public boolean isPalindrome2(String s) {
        int i = 0, end = s.length() - 1;
        while(i < end) {
            if (!isNormal(s.charAt(i))) i++;
            else if (!isNormal(s.charAt(end))) end--;
            else if ((s.charAt(i) + 32 - 'a') % 32 != (s.charAt(end) + 32 - 'a') % 32) return false;
            else {
                i++;
                end--;
            }
        }
        return true;
    }


    private boolean isNormal(char c) {
        return  (c >= 'a' && c <= 'z') || ( c >= 'A' && c <= 'Z') || ( c >= '0' && c <= '9');
    }
}
