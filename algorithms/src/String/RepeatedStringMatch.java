package String;

import org.junit.Test;


/**
 * reference:  http://www.cnblogs.com/grandyang/p/7631434.html
 */
public class RepeatedStringMatch {
    
    @Test
    public void test() {
        String A = "abc"; // abcabcabc
        String B = "cab";
        System.out.println(repeatedStringMatch(A, B));
    }

    public int repeatedStringMatch(String A, String B) {

        int lena = A.length();
        int lenb = B.length();

        int count = 1;

        String newA  = A;

        while (lena < lenb) {
            newA += (A);
            count++;
            lena = newA.length();
        }

        if (newA.contains(B)) return count;

        newA += A;
        count = count + 1;

        if (newA.contains(B)) return count ;


        return -1;


    }
}
