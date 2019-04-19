package interviewMedium.math;

import org.junit.Test;

/**
 * reference:
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/819/discuss/25047/A-Binary-Search-Solution
 */
public class Sqrt {

    @Test
    public void test() {
        int x = 8;
        System.out.println(mySqrt(x));
    }

    public int mySqrt(int x) {
//        double a = Math.sqrt(x);
//        System.out.println(a);

        if (x == 1) return x;

        int left = 0, right = x;


        while(left < right) {

            int mid = left + (right - left) /2;

            System.out.println("mid: " + mid);

            if (mid <= x/mid) {
                if ((mid + 1) > x/(mid+1)) return mid; //不能使用* 因为两个int 相乘结果可能超过Integer.MAX_VALUE 会溢出。
                else left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left + "-" +  right);

        return left * left <= x ? left : left - 1;//return left - 1;
    }
}
