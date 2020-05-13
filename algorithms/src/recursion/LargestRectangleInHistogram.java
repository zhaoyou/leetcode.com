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


    /**
     * https://leetcode.com/problems/
     * largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int[] lessLeft = new int[heights.length];
        int[] lessRight = new int[heights.length];

        lessLeft[0] = -1;

        lessRight[heights.length - 1] = heights.length;


        int maxArea = 0;




        for(int i = 1; i < heights.length; i++) {

            int p = i - 1;

            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessLeft[p];
            }

            lessLeft[i] = p;

        }




        for(int j = heights.length - 2; j >= 0; j--) {
           int p = j + 1;

           while( p < heights.length && heights[p] >= heights[j]) {
               p = lessRight[p];
           }

           lessRight[j] = p;

        }


        for(int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessRight[i] - lessLeft[i] -1));
        }

        return maxArea;
    }

    @Test
    public void test() {
        int [] heights = {2, 1, 5, 6, 2, 3};
        int[] heights2 = {1, 2, 3, 4};
        System.out.println(largestRectangleArea(heights));
        System.out.println(largestRectangleArea2(heights));

        System.out.println(largestRectangleArea(heights2));
        System.out.println(largestRectangleArea2(heights2));


    }
}
