package interviewEasy.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * reference:
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/discuss/15472/Short%2BSimple-Java-using-Strings/254098
 */
public class ValidSudoku {


    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for(int row = 0; row < 9; row++) {

            for(int col = 0; col < 9; col++) {

                if (board[row][col] != '.') {
                    String v = "[" + board[row][col] + "]";

                    if (!set.add(row + v) || !set.add(v + col) || !set.add((row / 3) + v + (col / 3))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
