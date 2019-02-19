package binarysearch;

import org.junit.Test;

public class SearchA2DMatrix {
    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     *
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     * Example 1:
     *
     * Input:
     * matrix = [
     *   [1,   3,  5,  7],
     *   [10, 11, 16, 20],
     *   [23, 30, 34, 50]
     * ]
     * target = 3
     * Output: true
     * Example 2:
     *
     * Input:
     * matrix = [
     *   [1,   3,  5,  7],
     *   [10, 11, 16, 20],
     *   [23, 30, 34, 50]
     * ]
     * target = 13
     * Output: false
     *
     * 由于数组是每行的元素都是有序的，并且每行的第一个元素比上一行的最后一个元素大，所以可以把二位数组看成一个有序的一维数组，直接利用
     * 二分查找有序数组即可。只要把找到的中间点的数据，转换成二位数组对应的行列下标即可
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length, cols = matrix[0].length;

        int left = 0, right = rows * cols;

        while(left < right) {

            int mid = left + (right - left)/2;


            int row = mid / cols;
            int col = mid % cols ;

            //System.out.println("mid: " + mid + " row: " + row + " col: " + col);
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int [][] matrix = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = 10;

        System.out.println(searchMatrix(matrix, target));
    }
}
