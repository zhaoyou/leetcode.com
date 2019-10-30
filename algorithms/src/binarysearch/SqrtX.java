package binarysearch;

import javassist.ClassPool;
import org.junit.Assert;
import org.junit.Test;

public class SqrtX {

    public int mySqrt(int x) {

        int right = x ;/// 2;
        int left = 0;

        if (x == 0) return 0;
        if (x == 1) return 1;

        while(left <= right) {

            int mid = left + (right - left) / 2;

            if (x/mid == mid) {
                return mid;
            } else if (x/mid > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    static final int SIZE=2*1024*1024;


    @Test
    public void test() {
        Assert.assertEquals(mySqrt(5), 2);
        Assert.assertEquals(mySqrt(3), 1);

        Assert.assertEquals(mySqrt(9), 3);

        Assert.assertEquals(mySqrt(8), 2);

        Assert.assertEquals(mySqrt(10), 3);
        Assert.assertEquals(mySqrt(0), 0);

        Assert.assertEquals(mySqrt(1), 1);
        Assert.assertEquals(mySqrt(2), 1);

        System.out.println(mySqrt(2147395599));

    }

    static javassist.ClassPool cp = javassist.ClassPool.getDefault();

    public static void main(String[] args) throws Exception{
        SqrtX.main(null);
    }

    public static Class generate(String name) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        return pool.makeClass(name).toClass();
    }
}

