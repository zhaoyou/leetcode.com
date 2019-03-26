package interviewEasy.Array;

import org.junit.Test;

import java.util.Arrays;

public class PlusOne {

    @Test
    public void test() {
        int [] digits = {9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {

        int sign = 1;

        for(int i = digits.length - 1; i >=0; i--) {
            int sum = sign  + digits[i];
            if (sum < 10) {
                digits[i]  = sum;
                return digits;
            } else {
                sign = 1;
                digits[i] = sum % 10;
            }
        }


        int [] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }

}
