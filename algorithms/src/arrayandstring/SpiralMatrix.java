package arrayandstring;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * reference：
 * https://leetcode.com/problems/spiral-matrix/discuss/20599/Super-Simple-and-Easy-to-Understand-Solution
 */
public class SpiralMatrix {

    /**
     * 参考引用连接，以游戏开放的过程实现
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder3(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        if (matrix.length == 0) return list;

        int m = matrix.length;      // 行
        int n = matrix[0].length;   // 列

        int[][] dirs = { {1, 0}, {0, -1}, {-1, 0}, {0, 1}}; // 方向偏移量 从右上角开始计算
        int[] pos = {0, n - 1}; // 右上角顶点

        int d = 0; // 控制方向

        // 添加第一行
        for(int i: matrix[0]) list.add(i);

        int i = (m - 1) * n ; // 统计还需要比遍历的元素。第一行已经添加了

        while (i > 0) {

            for(int k = 1; k < m; k++) {

                i--;
                pos[0] += dirs[d][0];   // 行
                pos[1] += dirs[d][1];   // 列

                list.add(matrix[pos[0]][pos[1]]);
            }

            m--;

            // 交互行， 列顺序
            int temp = m;
            m = n;
            n = temp;

            d = (d + 1) % 4;  // 改变方向  0， 1， 2， 3， 0 ...
        }

        return list;
    }

        // 参考引用连接的实现
    public List<Integer> spiralOrder2(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        if (matrix.length == 0) return list;

        int rowBegin = 0, colBegin = 0, rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;

        while(rowBegin <= rowEnd && colBegin <= colEnd) {


            // 从左到右遍历，rowBegin
            for(int j = colBegin; j <= colEnd; j++) {
                list.add(matrix[rowBegin][j]);
            }
            rowBegin++;


            // 从上到小遍历，减少colEnd 索引
            for(int j = rowBegin; j <= rowEnd; j++) {
                list.add(matrix[j][colEnd]);
            }
            colEnd--;


            // 从右到左遍历，减少 rowEnd

            if (rowBegin <= rowEnd) {
                for(int j = colEnd; j >= colBegin; j--) {
                    list.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            // 从下往上遍历， 减少 colBegin
            if (colBegin <= colEnd) {
                for(int j = rowEnd; j >= rowBegin; j--) {
                    list.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }

        return list;

    }

    // 自己实现
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        if (matrix.length == 0) return list;

        // 从行开始计算最后一个算行的，col会要少算一个
            int m = matrix.length - 1, n = matrix[0].length ;

            int r = 0;
            int c = 0;


            boolean c_plus = true;
            boolean r_plus = true;

            int total = ((m+1) * n);


            // 依次从 topLeft -> topRight -> buttomRight -> buttomLeft  循环
            // 每个步骤走的step 刚好是 列数n 依次递减  行数-1 (m-1)（第一行最后一个算列数） 依次递减
            // 直到最后不小于1，依次走，直到List满了

            while(list.size() < total) {

                for(int i = 0; i < n; i++) {
                    if (c_plus)
                        list.add(matrix[r][c++]);
                    else
                        list.add(matrix[r][c--]);
                }

               if (c_plus) {
                   c--;
                   r++;
               } else {
                   c++;
                   r--;
               }
                c_plus = !c_plus;
                if (n > 1) n--;

                if (list.size() == total) break;

                for(int k = 0; k < m; k++) {
                    if (r_plus) {
                        list.add(matrix[r++][c]);
                    } else {
                        list.add(matrix[r--][c]);
                    }
                }

                if (r_plus) {
                    r--;
                    c--;
                } else {
                    c++;
                    r++;
                }

                r_plus = !r_plus;
                if (m > 1) m--;

            }

            return list;
    }

    @Test
    public void test() {
        int[][] matrix = {
                {1,2, 3}, {4, 5, 6}, {7, 8, 9}
        };

        int[][] matrix2 = {
                {1,2, 3, 4}, { 5, 6, 7, 8}, { 9, 10, 11, 12}
        };


        int[][] matrix3 = {
                {1,2, 3, 4}
        };

        int[][] matrix4 = {
                {1,2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}, {11, 12}
        };

        int[][] matrix5 = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}
        };
        System.out.println(spiralOrder2(matrix));
        System.out.println(spiralOrder3(matrix));

        System.out.println(spiralOrder2(matrix2));
        System.out.println(spiralOrder3(matrix2));

        System.out.println(spiralOrder2(matrix3));
        System.out.println(spiralOrder3(matrix3));

        System.out.println(spiralOrder2(matrix4));
        System.out.println(spiralOrder3(matrix4));

        System.out.println(spiralOrder2(matrix5));
        System.out.println(spiralOrder3(matrix5));

    }
}
