package interviewMedium.ArrayAndString;

import java.util.Arrays;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int [] dpRows = new int[rows];
        int[] dpCols = new int[cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dpRows[i] = 0;
                    break;
                } else {
                    dpRows[i]++;
                }
            }
        }

        for(int k = 0; k < cols; k++) {
            for(int j = 0 ; j < rows; j ++) {
                if (matrix[j][k] == 0) {
                    dpCols[k] = 0;
                    break;
                } else {
                    dpCols[k]++;
                }
            }
        }

        for(int i = 0; i < rows; i++) {
            for(int k = 0; k < cols; k++) {
                if (dpRows[i] == 0 || dpCols[k] == 0) matrix[i][k] = 0;
            }
        }
    }
}
