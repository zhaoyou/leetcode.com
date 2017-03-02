package ReverseInteger;

import org.junit.Test;
import org.omg.PortableInterceptor.Interceptor;

/**
 * Created by zhaoyou on 02/03/2017.
 */
public class ReverseInteger {

    public int reverse(int x) {

        StringBuffer sb  = new StringBuffer(Math.abs(x) + "");
        int result = 0;
        try {
            result = Integer.parseInt(sb.reverse().toString());
            result = x < 0 ? -result : result;
        } catch (Exception e) {
            //e.printStackTrace();
            return 0;
        }
        return result;
    }


    @Test
    public void test() {
        int i = 1000000003;
        System.out.println(reverse(i));
    }
}
