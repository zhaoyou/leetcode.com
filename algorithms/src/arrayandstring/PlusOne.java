package arrayandstring;

import org.junit.Test;

import java.util.Arrays;

/**
 * reference:
 * https://leetcode.com/problems/plus-one/discuss/24082/My-Simple-Java-Solution
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        int res = 1;
        int len = digits.length;

        for(int j = len - 1; j >= 0; j--) {
            if (digits[j] + res> 9) {
                digits[j] = (digits[j] + res ) % 10;
                res = 1;
            } else {
                digits[j] += 1;
                return digits;
            }
        }

        int[] result = new int[len + 1];
        result[0] = 1;
        return result;
    }


    @Test
    public void test() {
        int[] digits = {0};
        System.out.println(Arrays.toString(plusOne(digits)));
    }



}
