package recursion;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }


    private boolean solve(char[][] board) {

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for(char c = '0'; c < '9'; c++) {

                        if (isValid(board, i, j, c)) {

                            board[i][j] = c;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }


                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {

        int prefix_row = 3 * (row / 3);
        int prefix_col = 3 * (col / 3);

        for(int i = 0 ; i < 9; i++) {
            if (board[row][i] == c) return false;
            if (board[i][col] == c) return false;

            if (board[prefix_row + i / 3][prefix_col + i % 3] == c) return false;

        }
        return true;
    }
}
