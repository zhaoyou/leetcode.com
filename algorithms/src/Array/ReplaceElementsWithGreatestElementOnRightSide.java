package Array;

import org.junit.Test;

import java.util.Arrays;

public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int N = arr.length;
        int max = - 1 , prev = -1;

        for(int i = N - 1; i >= 0; i-- ) {
            max = Math.max(max, prev);
            prev = arr[i];
            arr[i] = max;
        }
        return arr;
    }


    @Test
    public void test() {
        int [] arr = {17};
        System.out.println(Arrays.toString(replaceElements(arr)));
    }
}
