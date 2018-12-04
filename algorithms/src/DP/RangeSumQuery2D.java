package DP;


import org.junit.Test;

/**
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 */
public class RangeSumQuery2D {

    class NumMatrix {

        int[][]dp;
        int rows;
        int cols;

        public NumMatrix(int[][] matrix) {

            rows = matrix.length;

            if (rows == 0) return;

            cols = matrix[0].length;

            dp = new int[rows][cols];


            dp[0][0] = matrix[0][0];

            for (int i = 1; i < cols; i++) {
                dp[0][i] = dp[0][i - 1] + matrix[0][i];  // 设置第一行

                //System.out.println("dp[0][" + i + "]: " + dp[0][i]);
            }

//            for(int k = 0; k < rows; k++) {
//                for(int j = 0; j < cols; j++) {
//                    //System.out.print("dp[" + k + "][" + j + "]= " + dp[k][j] + " ");
//                    System.out.print(" " +  matrix[k][j] + " ");
//                }
//
//                System.out.println("");
//            }
//
//            System.out.println("==================");
//

            for(int i = 1; i < rows; i++) {

                dp[i][0] = dp[i-1][0] + matrix[i][0]; // 设置每行的第一列

                int sum = matrix[i][0];

                for (int j = 1; j < cols; j++) {

                    sum += matrix[i][j];

                    dp[i][j] = dp[i - 1][j] + sum ;

                }
            }

//            for(int k = 0; k < rows; k++) {
//                for(int j = 0; j < cols; j++) {
//                    //System.out.print("dp[" + k + "][" + j + "]= " + dp[k][j] + " ");
//                    System.out.print(" " +  dp[k][j] + " ");
//                }
//
//                System.out.println("");
//            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {

            if (rows == 0) return 0;

            if (row1 == 0 && col1 == 0) return dp[row2][col2];

            if (row1 == 0) {
                return dp[row2][col2] - dp[row2][col1 - 1];
            }

            if (col1 == 0) {
                return dp[row2][col2] - dp[row1 - 1][col2];
            }

            return dp[row2][col2] - dp[row2][col1 - 1] - dp[row1 - 1][col2] + dp[row1 - 1][col1 - 1];
        }
    }

    @Test
    public void test() {
        int[][] matrix = {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};

        NumMatrix obj = new NumMatrix(matrix);
        int row1 = 0;
        int col1 = 1;
        int row2 = 1;
        int col2 = 2;
        int param_1 = obj.sumRegion(row1,col1,row2,col2);
        System.out.println("\n" + param_1);
    }

}
