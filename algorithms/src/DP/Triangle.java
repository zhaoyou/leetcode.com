package DP;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {

    @Test
    public void test() {
        List list1 = Arrays.asList(-1);
        List list2 = Arrays.asList(2, 3);
        List list3 = Arrays.asList(1, -1, -3);
//        List list4 = Arrays.asList(4, 1, 8, 3);

        List triangle = Arrays.asList(list1, list2, list3);

        System.out.println(minimumTotal(triangle));

    }


    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle.size() == 1) return triangle.get(0).get(0);

        int length = triangle.size();

        int[][] dp = new int[length][length];

        for(int i = 0; i < triangle.get(length - 1).size(); i++) {
            dp[length - 1][i] = triangle.get(length - 1).get(i);
        }


        for (int j = length - 2; j >= 0; j--) {
            List<Integer> subList = triangle.get(j);

            for (int k = 0; k < subList.size(); k++) {
                dp[j][k] = Math.min(dp[j + 1][k], dp[j + 1][k+1]) + subList.get(k);
            }
        }

        return dp[0][0];
    }
}
