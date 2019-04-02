package interviewEasy.Math;

import org.junit.Test;

public class CountPrimes {

    @Test
    public void test() {
        int n = 3;
        System.out.println(countPrimes(n));
    }


    public int countPrimes(int n) {

        if (n <= 2) return 0;

        int[] dp = new int[n];
        int i = 2;
        while(i < n) {

            if (dp[i] == 0) {

                for(int j = 2; i * j < n; j++) {
                    dp[i * j] = 1;
                }
            }
            i++;
        }
        int res = 0;
        for(int k = 2; k < n; k++) if(dp[k]== 0) res++;
        return res;
    }
}
