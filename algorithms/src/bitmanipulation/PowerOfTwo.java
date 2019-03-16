package bitmanipulation;

import org.junit.Test;

public class PowerOfTwo {

    @Test
    public void test() {
        int n = 8;
        System.out.println(isPowerOfTwo(n));
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
