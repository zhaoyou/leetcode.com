package heap;

import org.junit.Test;

import java.util.Arrays;

public class KClosestPointsToOrigin {


    @Test
    public void test() {
        /**
         * [[-41,72},{53,83},{-95,-31},{-61,68},{32,-56},{16,88},{-81,-48},{-31,56},{-57,-74},{24,-42},{-59,72},{-86,40},{34,-85},{-45,22},{-35,-95]]
         * 9
         */
        
        
        int[][] points = {{3,3}, {5,-1}, {-2,4}};//{{0, 1}, {1, 0}};//{{3,3}, {5,-1}, {-2,4}};//{{1,3}, {-2,2}};//{{2,2}, {2,2}, {2,2}, {2,2}, {2,2}, {2,2}, {1,1}};

                //{{1,3}, {-2,2}};
        
        //{{-41,72},{53,83},{-95,-31},{-61,68},{32,-56},{16,88},{-81,-48},{-31,56},{-57,-74},{24,-42},{-59,72},{-86,40},{34,-85},{-45,22},{-35,-95}};

        int K = 2;
                //K = 1;


        for(int [] point: kClosest(points, K)) {
            System.out.println(Arrays.toString(point));
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        bs(points, 0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void bs(int[][] points, int left, int right, int k) {
        if (left > right) return;
        int i = partion(points, left, right);

        if (i == k) return;

        if (i > k) {
            bs(points, left, i - 1, k);
        } else {
            bs(points, i + 1, right, k);
        }
    }

    private int partion(int[][] points, int left, int right) {


        int[] p = points[left];


        while(left < right) {


            while(getistance(points[right]) >= getistance(p) && left < right) {
                right--;
            }

            points[left] = points[right];



            while(getistance(points[left]) <= getistance(p) && left < right) {
                left++;
            }

            points[right] = points[left];


        }

        points[left] = p;

        return left;

    }

    @Test
    public void test2() {
        int[] arr = {6, 5, 5, 5, 5};
        sort3(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void sort3(int[] arr, int left, int right) {
        if (left >= right ) return;

        int i = partion(arr, left, right);
        sort3(arr, left, i - 1);
        sort3(arr, i + 1, right);
    }

    private int partion(int[] arr, int left, int right) {
        int pivot = arr[left];


        while(left < right) {
            while(left < right && arr[right] >= pivot) right--;
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) left++;
            arr[right] = arr[left];

        }

        arr[left] = pivot;
        return left;
    }




    private double getistance(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }



    public static void main(String[] args) {
        int[] a = {3, 4};
        System.out.println(new KClosestPointsToOrigin().getistance(a));
    }
}
