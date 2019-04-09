package interviewMedium.Tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * reference:
 * DFS
 * http://www.cnblogs.com/grandyang/p/4402656.html
 * UNION-FIND
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/792/discuss/56354/1D-Union-Find-Java-solution-easily-generalized-to-other-problems
 */
public class NumberOfIslands {

    @Test
    public void test() {
        char[][] grid = {
                { '1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0' ,'0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                { '1', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1' ,'0', '1'}
        };


        char[][] grid3 = {
                { '1', '1', '0', '0', '0'},
                { '1', '1', '0', '0', '0'},

                {'0', '0', '1' ,'0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        
        char[][] grid4 = {
                
                {'1','1','1','1','1','1'},
                {'1','0','0','0','0','1'},
                {'1','0','1','1','0','1'},
                {'1','0','0','0','0','1'},
                {'1','1','1','1','1','1'}
        };

        System.out.println("size： " + numIslands(grid4));
    }

    public int numIslands2(char[][] grid) {

        if (grid == null) return 0;
        int rows = grid.length;

        if (rows == 0) return 0;
        int cols = grid[0].length;

        int count = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i , int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public int numIslands(char[][] grid) {

        if (grid == null) return 0;
        int rows = grid.length;

        if (rows == 0) return 0;
        int cols = grid[0].length;

        int [] dp = new int[rows * cols];

        System.out.println("rows: " + rows + " cols:  "+ cols);

        Arrays.fill(dp, -1);


        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {

                if (grid[i][j] == '1') {

                    dp[i * cols + j] = i * cols + j;

                    if (i > 0 && grid[i-1][j] == '1') {
                        //dp[i] = dp[(row - 1)* col + col]; // 如果上一个为1 ， 则把当前也设置成和上一个一样
                        setSameParent(dp,  i * cols + j, (i - 1) * cols + j);
                    }

                    if (j > 0 && grid[i][j-1] == '1') {

                        setSameParent(dp,  i * cols + j - 1, i * cols + j); // 如果前一个为1， 则把前一个相同的value，都设置为当前i的值 dp[i]
                    }

                }
            }

        }

        Set<Integer> set = new HashSet();

        for(int j = 0; j < dp.length; j++) {
            if (dp[j] != -1) {
               // System.out.println(dp[j]);
                set.add(dp[findRoot(dp, j)]);
            }
        }

        return set.size();
    }


    private int findRoot(int[] dp, int x) {
        if (dp[x] == x) return x;
        return findRoot(dp, dp[x]);
    }

    private void setSameParent(int[] dp, int value, int newValue) {

//        for(int i = 0; i < dp.length; i++) {
//            if (dp[i] == value) dp[i] = newValue;
//        }

        int root  = findRoot(dp, value);
        int newRoot = findRoot(dp, newValue);

        dp[root] = dp[newRoot];

    }
}
