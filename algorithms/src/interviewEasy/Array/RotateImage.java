package interviewEasy.Array;

import org.junit.Test;

import java.util.Arrays;

/**
 * reference:
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/discuss/18879/AC-Java-in-place-solution-with-explanation-Easy-to-understand.
 */
public class RotateImage {

    @Test
    public void test() {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2,4,8,10},
                {13,3, 6, 7},
                {15,14,12,16}
                };

        rotate(matrix);
        for(int[] s: matrix)
        System.out.println(Arrays.toString(s));

    }

    public void rotate(int[][] matrix) {

        // 先行列转换， 在每行的前后对调
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }

    }
}
