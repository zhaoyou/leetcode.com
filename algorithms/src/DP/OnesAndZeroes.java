package DP;

import org.junit.Test;

public class OnesAndZeroes {

    @Test
    public void test() {
//        String[] strs = {"10","0001","111001","1","0"};
        String[] strs = {"10","0","1"};
        int m = 1, n = 1;
//        int m = 5, n = 3;
        System.out.println(findMaxForm(strs, m, n));
        System.out.println(findMaxForm2(strs, m, n));

    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(String str: strs) {
            int zeroCount = 0, oneCount = 0;
            for(char c: str.toCharArray()) { if (c == '0') zeroCount++; else oneCount++;}
            for(int i = m; i >= zeroCount; i--) {
                for(int j = n; j >= oneCount; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroCount][j - oneCount] + 1);
                }
            }
        }
        return dp[m][n];
    }



    public int findMaxForm2(String[] strs, int m, int n) {
        int l = strs.length;
        int[][][] dp = new int[l + 1][m + 1][n + 1];

        for(int k = 1; k <= l; k++) {

            int[] counts = getCount(strs[k - 1]);

            for(int i = 0; i <= m; i++) {
                for(int j = 0; j <= n; j++) {

                    if (k == 0) {
                        dp[k][i][j] = 0;
                    } else if ( i >= counts[0] && j >= counts[1]) {
                        dp[k][i][j] = Math.max(dp[k][i][j], dp[k - 1][i - counts[0]][j - counts[1]] + 1);
                    } else {
                        dp[k][i][j] = dp[k - 1][i] [j];
                    }
                }


            }
        }
        return dp[l][m][n];

    }

    private int[] getCount(String str) {
        int zeroCount = 0;
        int oneCount = 0;
        for(char c: str.toCharArray()) {
            if (c == '0') zeroCount++; else oneCount++;
        }
        return new int[]{zeroCount, oneCount};
    }

}
