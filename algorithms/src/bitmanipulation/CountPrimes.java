package bitmanipulation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CountPrimes {


    @Test
    public void test() {
        int n = 10;
        System.out.println(countPrimes(n));
    }

    public int countPrimes(int n) {
        boolean[] flag = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (flag[i] == false) {
                count++;

                for (int j = 2; j * i < n; j++) {
                    flag[j * i] = true;
                }
            }
        }

        return count;
    }
}
