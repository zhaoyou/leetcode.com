package hashtable;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    @Test
    public void test() {
        System.out.println(isHappy(15));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        do {
            int result = 0;
            while (n > 0) {
                result += Math.pow( n % 10, 2);
                n /= 10;
            }

            n = result;

            if (!set.add(n)) return false;

            if (n == 1) return true;

            System.out.println("result: " + result);

        } while(n != 1);

        return false;
    }
}
