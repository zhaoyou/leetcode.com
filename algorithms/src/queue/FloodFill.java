package queue;

import org.junit.Test;

import java.util.Arrays;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
           int rows = image.length;
           int cols = image[0].length;
           int oldColor = image[sr][sc];
           boolean[][] visted = new boolean[rows][cols];
           helper(image, visted, sr, sc, rows, cols, oldColor, newColor);
           return image;
    }

    private void helper(int[][] image, boolean[][] visted, int sr, int sc, int rows, int cols, int oldColor, int newColor) {
        if (sr < 0 || sr >= rows ||
                sc < 0 || sc >= cols || visted[sr][sc] || image[sr][sc] != oldColor ) return;

        visted[sr][sc] = true;
        image[sr][sc] = newColor;

        helper(image, visted, sr - 1, sc, rows, cols, oldColor, newColor);
        helper(image, visted, sr + 1, sc, rows, cols, oldColor, newColor);
        helper(image, visted, sr, sc - 1, rows, cols, oldColor, newColor);
        helper(image, visted, sr, sc + 1, rows, cols, oldColor, newColor);
    }

    @Test
    public void test() {
        int[][] image = {
                {1,1,1}, {1,1, 0}, {1, 0, 1}
        };
        int sr = 1, sc = 1;
        int newColor = 2;
        System.out.println(Arrays.deepToString(floodFill(image, sr, sc, newColor)));
    }
}
