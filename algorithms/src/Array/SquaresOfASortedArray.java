package Array;

import org.junit.Test;

import java.util.Arrays;

public class SquaresOfASortedArray {
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
        int[] nums = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}
