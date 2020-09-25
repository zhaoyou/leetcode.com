package Array;

import org.junit.Test;

import java.util.Arrays;

public class DuplicateZerosSolution {
    public void duplicateZeros(int[] arr) {
        int N = arr.length;

        for(int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                for(int j = N - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                i = i + 1;
            }
        }
    }

    @Test
    public void test() {
        int[] arr = {1,2,3};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
