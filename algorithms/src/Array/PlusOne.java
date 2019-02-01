package Array;

import org.junit.Test;

import java.util.Arrays;

/**
 * reference: https://leetcode.com/problems/plus-one/discuss/24082/My-Simple-Java-Solution
 */
public class PlusOne {

    @Test
    public void test() {
        int[] digits = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >=0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int [] result = new int[len + 1];

        result[0] = 1;

        return result;
    }
}
