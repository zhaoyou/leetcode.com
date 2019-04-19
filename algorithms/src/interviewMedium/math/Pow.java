package interviewMedium.math;

import org.junit.Test;

public class Pow {

    @Test
    public void test() {
        double x = 2;
        int n = Integer.MIN_VALUE;
       System.out.println(myPow(x, n));


    }

    public double myPow(double x, int n) {

        if (n == 0) return 1;

        if (n < 0) {
            x = 1/x;
            n = -n;
        }

        if (n == Integer.MIN_VALUE)  // 处理 n == Integer.MIN_VALUE n = -n  任然是  Integer.MIN_VALUE
            return myPow(x * x, -(n/2));


        return n % 2 == 0 ? myPow(x * x, n/2) : x*myPow(x * x, n/ 2);
//        if(n == 0)
//            return 1;
//        if(n<0){
//            n = -n;
//            x = 1/x;
//        }
//        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);

    }

}
