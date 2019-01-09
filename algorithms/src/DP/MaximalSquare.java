package DP;

import org.junit.Test;

/**
 * reference: http://www.cnblogs.com/grandyang/p/4550604.html
 */
public class MaximalSquare {

    @Test
    public void test() {
//        char[][] matrix = {
//                {'1','0','1','0','0'} ,
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'}
//        };

        char[][] matrix = {
                {'1'} ,

        };


        System.out.println(maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) {


        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        int res = 0;


        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (i == 0 || j == 0)  {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = 1;
                    }
                } else if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }

                res = Math.max(res, dp[i][j]);

            }
        }



        return res * res;
    }
}
