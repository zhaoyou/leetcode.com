package arrayandstring;

import org.junit.Test;

/**
 * reference:
 * https://leetcode.com/problems/diagonal-traverse/discuss/97711/Java-15-lines-without-using-boolean
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0) return new int[0];

        int rows = matrix.length;
        int cols = matrix[0].length;

        int [] arr = new int[rows * cols];
        int i = 0, j = 0;


        for (int k = 0; k < rows * cols; k++) {
            arr[k] = matrix[i][j];

            if ( (i + j) % 2 == 0) { // 找规律， 符合索引位置只和%2==0 则需要向上.
                if (j == cols - 1) {
                    i++;
                } else if (i == 0) {
                    j++;
                } else {
                    i--;
                    j++;
                }
            } else {               // 向下
                if( i == rows - 1) {
                    j++;
                } else if (j == 0) {
                    i++;
                } else {
                    i++;
                    j--;
                }
            }
        }

        return arr;
    }


    @Test
    public void test() {
        int[][] matrix = {{1,2,3}, {4, 5, 6}, {7, 8, 9}};
        findDiagonalOrder(matrix);
    }
}
