package ContainerWithMostWater;

/**
 * @author zhaoyou
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int source[] = {1,8,6,2,5,4,8,3,7};
        long start = System.currentTimeMillis();
        System.out.println(maxArea2(source));
        System.out.println("花费时间： " + (System.currentTimeMillis() - start));

    }


    /**
     * 暴力算法 O(n²)
     */
    public static int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return area;
    }

    public static int maxArea2(int[] height) {
        int area = 0;
        int i = 0, j = height.length - 1;
        while(i < j) {
            area = Math.max(area, Math.min(height[i], height[j]) * (j - i));

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return area;
    }
}
