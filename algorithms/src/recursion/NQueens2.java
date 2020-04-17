package recursion;

import java.util.HashSet;
import java.util.Set;

public class NQueens2 {

    private Set<Integer> cols = new HashSet<>(); // col

    private Set<Integer> diagnol1Set = new HashSet<>(); //  对角线  [/] row + col  sum 是一样的

    private Set<Integer> diagnol2Set = new HashSet<>(); // [\]  row - col  sub 是一样的
    /**
     * def backtrack_nqueen(row = 0, count = 0):
     *     for col in range(n):
     *         # iterate through columns at the curent row.
     *         if is_not_under_attack(row, col):
     *             # explore this partial candidate solution, and mark the attacking zone
     *             place_queen(row, col)
     *             if row + 1 == n:
     *                 # we reach the bottom, i.e. we find a solution!
     *                 count += 1
     *             else:
     *                 # we move on to the next row
     *                 count = backtrack(row + 1, count)
     *             # backtrack, i.e. remove the queen and remove the attacking zone.
     *             remove_queen(row, col)
     *     return count
     */

    public int totalNQueens(int n) {
        return helper(0, 0, n);
    }

    private Integer helper(int row, int count, int n) {
        for(int col = 0; col < n; col ++) {

            if (cols.contains(col)) continue;

            int diagnol1 = row + col;

            if (diagnol1Set.contains(diagnol1)) continue;

            int diagnol2 = row - col;
            if (diagnol2Set.contains(diagnol2)) continue;

            if (row == n - 1) {
                count ++;
            } else {


                cols.add(col);
                diagnol1Set.add(diagnol1);
                diagnol2Set.add(diagnol2);

                count =  helper(row + 1, count, n);

                cols.remove(col);
                diagnol1Set.remove(diagnol1);
                diagnol2Set.remove(diagnol2);

            }

        }

        return count;
    }
}
