package queue;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * reference:
 * https://leetcode.com/problems/01-matrix/discuss/101021/Java-Solution-BFS
 */
public class Matrix01 {
    public int[][] updateMatrix(int[][] matrix) {
       if(matrix == null)
           return matrix;

       int rows = matrix.length;
       int cols = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }


        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // 定义四个方向

        while(!queue.isEmpty()) {

            int[] cell = queue.poll();

            for(int[] dir: dirs) {
                int r = cell[0] + dir[0];
                int c = cell[1] + dir[1];

                if (r >= rows || r < 0 || c >= cols || c < 0) continue;

                if (matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                else {
                    matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
                    queue.add(new int[]{r, c});
                }
            }

        }

        return matrix;
    }


    @Test
    public void test() {
        int [][] matrix = {
                {0, 0, 0}, {0, 1, 0}, {1, 1, 1}
        };

        int [][] result = updateMatrix(matrix);

        System.out.println(Arrays.deepToString(result));
    }
}
