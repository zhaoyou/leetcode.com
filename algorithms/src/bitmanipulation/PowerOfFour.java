package bitmanipulation;

import org.junit.Test;

public class PowerOfFour {

    @Test
    public void test() {
        int num = 64;
        System.out.println(isPowerOfFour(num));
    }

    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & num - 1) == 0 && ((num - 1) % 3 == 0);
    }
}
