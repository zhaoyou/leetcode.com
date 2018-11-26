package DP;

import org.junit.Test;

import java.util.Arrays;
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

/**
 * reference: https://blog.csdn.net/Jin_Kwok/article/details/51418353
 */
public class Triangle {

    @Test
    public void test() {
        List list1 = Arrays.asList(2);
        List list2 = Arrays.asList(3, 4);
        List list3 = Arrays.asList(6, 5, 7);
        List list4 = Arrays.asList(4, 1, 8, 3);

        List triangle = Arrays.asList(list1, list2, list3, list4);

        System.out.println(minimumTotal2(triangle));

    }

    public int minimumTotal2(List<List<Integer>> triangle) {

        if (triangle.size() == 1) return triangle.get(0).get(0);

        int len = triangle.size();

        int dp[] = new int[len]; // 使用一个数组就存放

        for(int j = 0; j < triangle.get(len - 1).size(); j ++) {
            dp[j] = triangle.get(len - 1).get(j);
        }

        for (int i = len - 2; i >=0; i--) {
            List<Integer> subList = triangle.get(i);

            for(int j = 0; j < subList.size(); j++) {
                int num1 = dp[j] + triangle.get(i).get(j);
                int num2 = dp[j + 1] + triangle.get(i).get(j);

                dp[j] = Math.min(num1, num2); // 定义一个一维数组，每次保留一行的最优解，到最终 dp[0] 就是结果
            }
        }

        return dp[0];
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
