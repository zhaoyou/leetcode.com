package DivideTwoIntegers;

public class DivideTwoIntegers {

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(-2147483648, 1));
    }

    /**
     * https://blog.csdn.net/csdn_blog_lcl/article/details/77478607
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {

        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;


        int sign = ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor< 0)) ? -1 : 1;

        long did = Math.abs((long)dividend);

        long div = Math.abs((long)divisor);



        int result = 0;

        while(did >= div) {


            int mul = 1;

            long temp = div;

            while (did >= (temp << 1)) {
                temp <<= 1;
                mul <<= 1;
            }


            did -= temp;

            result += mul;

        }

        return sign == -1 ? 0 - result : result;
    }
}
