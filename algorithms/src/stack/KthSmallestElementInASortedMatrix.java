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
//        int [][] matrix = {
//                {1, 5, 9},
//                {10,11,13},
//                {12,13,15}
//        };
        int [][] matrix = {
                {1,2},
                {1,3}
        };
        int k = 2;
        System.out.println(kthSmallest(matrix, k));
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
}
