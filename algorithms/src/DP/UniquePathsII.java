package DP;

import org.junit.Test;

/**
 * https://blog.csdn.net/linhuanmars/article/details/22135231 (未理解）
 */
public class UniquePathsII {

    @Test
    public void test() {
        int [][] obstacleGrid =
//                {
//                {0,0}, {0,0}, {0,0}
//        };

         {{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};



//        for(int k = 0; k < obstacleGrid.length; k++) {
//            for(int j = 0; j < obstacleGrid[k].length; j++) {
//                System.out.print( obstacleGrid[k][j] + " ");
//            }
//            System.out.println("");
//        }

        System.out.println("============== ");
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        System.out.println(uniquePathsWithObstacles2(obstacleGrid));

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;


        int[][] result = new int[m][n];

        result[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0; // 判断顶点是否可行


        // 处理所有行的第一列
        for(int i = 1; i < n ; i++) {
            if (result[0][i - 1] == 1 && obstacleGrid[0][i] == 0) { // 当前位置可行，且上一个位置也可以行
                result[0][i] = 1;
            }
        }

        // 处理每列的第一个
        for(int j = 1; j < m; j++) {
            if (result[j - 1][0] == 1 && obstacleGrid[j][0] == 0) // 当前位置可行，且左边位置也可行
               result[j][0] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0)
                  result[i][j] = result[i - 1][j] + result[i][j-1]; // 一个位置有多少可行路线 等于它的上面 + 左边（并且当前位置也行）
            }
        }

        return result[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
         int rows = obstacleGrid.length;
         int cols = obstacleGrid[0].length;

         int dp[] = new int[cols];

         dp[0] = (obstacleGrid[0][0] == 0) ? 1 : 0;

         for(int i = 0; i < rows; i++) {

             dp[0] = obstacleGrid[i][0] == 1 ? 0 : dp[0];

             for(int j = 1; j < cols; j++) {

//                 if (i == 0) {
//                     dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j - 1];
//                 } else {
                     dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j - 1] + dp[j];
//                 }


             }
         }

         return dp[cols - 1];
    }
}
