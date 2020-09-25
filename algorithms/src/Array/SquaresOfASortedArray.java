package Array;

import org.junit.Test;

import java.util.Arrays;

public class SquaresOfASortedArray {

    public int[] sortedSquares2(int[] A) {
        int N = A.length;
        int[] result = new int[N];

        int s = 0, e = N - 1, index = N - 1;

        while( s <= e) {
            if (A[e] * A[e] > A[s] * A[s]) {
                result[index--] = A[e] * A[e];
                e--;
            } else  {
                result[index--] = A[s] * A[s];
                s++;
            }
        }

        return result;
    }
        public int[] sortedSquares(int[] A) {
        int N = A.length;
        int [] result = new int[N];

        int j = 0;

        while(j < N && A[j] < 0)
            j++;

        int i = j - 1;
        int index = 0;

        // 负数部分数组的平方也是一个倒序的数组
        while( i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                result[index++] = A[i] * A[i];
                i--;
            } else {
                result[index++] = A[j] * A[j];
                j++;
            }


        }

        while(i >= 0) {
            result[index++] = A[i] * A[i];
            i--;
        }

        while(j < N) {
            result[index++] = A[j] * A[j];
            j++;
        }

        return result;
    }

    @Test
    public void  test() {
        int[] nums = {-1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(sortedSquares(nums)));
        System.out.println(Arrays.toString(sortedSquares2(nums)));

    }
}
