package recursion;

import org.junit.Test;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        int max = 0;
        for(int i = 0; i < size; i++) {

            int subMax = heights[i];
            int minHeight = heights[i];

            for (int j = i + 1; j < size; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                subMax = Math.max(subMax, minHeight * (j - i + 1));
            }

            max = Math.max(max, subMax);
        }
        return max;
    }

    @Test
    public void test() {
        int [] heights = {2, 1, 5, 6, 2, 3};
        int[] heights2 = {1, 2, 3, 4};
        System.out.println(largestRectangleArea(heights));
        System.out.println(largestRectangleArea(heights2));

    }
}
