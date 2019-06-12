package binarysearch;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class BinarySearchDemo {

    int[] arr = {1, 3, 5, 7, 9};

    @BeforeClass
    public static void preTest() {
        System.out.println(Arrays.toString(new BinarySearchDemo().arr));
    }


    @Test
    public void test() {
        int target = 0;
        System.out.println(target + " in array : "  + binarySearch(arr, target));
        System.out.println(target + " in array : "  + binarySearch2(arr, target));
    }

    @Test
    public void test2() {
        int target = 3;
        System.out.println(target + " in array : "  + binarySearch(arr, target));
        System.out.println(target + " in array : "  + binarySearch2(arr, target));
    }

    @Test
    public void test3() {
        int target = 4;
        System.out.println(target + " in array : "  + binarySearch(arr, target));
        System.out.println(target + " in array : "  + binarySearch2(arr, target));

    }

    @Test
    public void test4() {
        int target = 9;
        System.out.println(target + " in array : "  + binarySearch(arr, target));
        System.out.println(target + " in array : "  + binarySearch2(arr, target));
    }

    @Test
    public void test5() {
        int target = 10;
        System.out.println(target + " in array : "  + binarySearch(arr, target));
        System.out.println(target + " in array : "  + binarySearch2(arr, target));
    }



    public int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length;

        while(left < right) {
            int mid = left + (right - left)/2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid;
            }
        }

        return -1;
    }

    public int binarySearch2(int [] arr, int target) {
        int left = 0, right = arr.length - 1;

        while(left <= right) {
            int mid = left + (right - left)/2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid -1;
            }
        }

        return -1;
    }
}
