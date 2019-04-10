package interviewMedium.backtracking;

import org.junit.Test;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 *
 * reference:
 * http://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/797/discuss/27658/Accepted-very-short-Java-solution.-No-additional-space./244587
 */
public class WordSearch {

    @Test
    public void test() {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                 {'A','D','E','E'}
        };

        String word = "ABCB";
        System.out.println(exist(board, word));
    }

    public boolean exist(char[][] board, String word) {

        if (board.length == 0) return false;

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visted = new boolean[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0))  //找到第一个字母的入口
                    if (helper(board, visted, word, i, j, rows, cols, 0)) return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board,
                           boolean[][] visted,
                           String word,
                           int row,
                           int col,
                           int rows,
                           int cols,
                           int index) {

        if (index == word.length()) {
            return true;
        }


        if (row < 0 || row >= rows || col < 0 || col >= cols || visted[row][col]
                || board[row][col] != word.charAt(index)) {
            return false;
        }


        visted[row][col] = true;

        boolean result = helper(board, visted, word, row + 1, col, rows, cols,index+1) ||
                         helper(board, visted, word, row - 1, col, rows, cols,index+1) ||
                         helper(board, visted, word, row , col + 1, rows, cols,index+1) ||
                         helper(board, visted, word, row , col - 1, rows, cols,index+1);

        visted[row][col] = false;

        return result;


    }

}
