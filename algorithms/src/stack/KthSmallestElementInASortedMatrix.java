package stack;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * reference:
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
 * http://www.cnblogs.com/grandyang/p/5727892.html#commentform
 */
public class KthSmallestElementInASortedMatrix {

    @Test
    public void test() {
        int [][] matrix = {
                {1, 5, 9},
                {10,11,13},
                {12,13,15}
        };
//        int [][] matrix = {
//                {1,2},
//                {1,3}
//        };
        int k = 8;
        System.out.println(kthSmallest2(matrix, k));
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int rows = matrix.length, cols = matrix[0].length;

        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                queue.offer(matrix[i][j]);
                if (queue.size() > k)  queue.poll();
            }
        }
        return queue.peek();
    }



    public int kthSmallest2(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length;
        int left = matrix[0][0], right = matrix[rows-1][cols-1];

        while(left < right) {

            int mid = left + (right - left) / 2;

            //System.out.println("left: " + left + " right: " + right + " mid: " + mid);

            int count = findLessThanTarget(matrix, mid);


            if (count < k) left = mid + 1;
            else {
                right = mid ;
            }
        }

        return left;
    }

    /**
     * 找到不大于某个target的个数
     * @param matrix
     * @param target
     * @return
     */
    public int findLessThanTarget(int[][] matrix, int target) {
        int res = 0;
        int rows = matrix.length, cols = matrix[0].length;
        int i = rows - 1, j = 0;

        while(i >= 0 && j < cols) {
            if (matrix[i][j] <= target) {
                res += i + 1;
                j++;
            } else {
                i--;
            }
        }

        return res;
    }
}
