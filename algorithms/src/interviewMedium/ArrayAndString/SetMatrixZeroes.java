package interviewMedium.ArrayAndString;

import java.util.Arrays;

/**
 * reference:
 * https://www.cnblogs.com/grandyang/p/4341590.html
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/777/discuss/26008/My-AC-java-O(1)-solution-(easy-to-read)
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int [] dpRows = new int[rows];
        int[] dpCols = new int[cols];

        Arrays.fill(dpCols, 1);
        Arrays.fill(dpRows, 1);

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dpRows[i] = 0;
                    dpRows[j] = 0;
                }
            }
        }

//        for(int k = 0; k < cols; k++) {
//            for(int j = 0 ; j < rows; j ++) {
//                if (matrix[j][k] == 0) {
//                    dpCols[k] = 0;
//                    break;
//                } else {
//                    dpCols[k]++;
//                }
//            }
//        }

        for(int i = 0; i < rows; i++) {
            for(int k = 0; k < cols; k++) {
                if (dpRows[i] == 0 || dpCols[k] == 0) matrix[i][k] = 0;
            }
        }
    }
}
