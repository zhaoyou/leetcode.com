package Array;

import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] copyArr = Arrays.copyOfRange(heights, 0, heights.length);
        Arrays.sort(copyArr);
        int k = 0;
        for(int i = 0; i < copyArr.length; i++) {
            if (copyArr[i] != heights[i]) k++;
        }

        return k;
    }
}
