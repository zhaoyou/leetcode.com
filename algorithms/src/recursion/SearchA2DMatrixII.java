package recursion;

public class SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        return helper(matrix, target,  0, matrix[0].length - 1);
    }

    private boolean helper(int[][] matrix, int target, int row, int col) {
        if (row >= matrix.length || col < 0) return false;

        if (matrix[row][col] == target) return true;

        if (matrix[row][col] > target) {
            return helper(matrix, target, row, col - 1);
        } else {
            return helper(matrix, target, row + 1, col);
        }
    }
}
