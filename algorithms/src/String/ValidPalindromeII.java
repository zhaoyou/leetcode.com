package String;

import org.junit.Test;

public class ValidPalindromeII {

    @Test
    public void test() {
        String s = "2111111";
        System.out.println(s + " -> " + validPalindrome(s));

//        System.out.println(s + "substring(0, 1)" + s.substring(0, 1));
    }


    public boolean validPalindrome(String s) {
        return helper(s, true);
    }

    private boolean helper(String s, boolean canDelete) {
        if (s.length() == 1) return true;

        int len = s.length();

        int start = 0, end = len - 1;


        while(start < end) {

            if (s.charAt(start) != s.charAt(end)) {

                if (!canDelete) return false;

                return helper(s.substring(start, end), false)
                        || helper(s.substring(start + 1, end+1), false);

            }

            start++;
            end--;

        }
        return true;
    }
}
