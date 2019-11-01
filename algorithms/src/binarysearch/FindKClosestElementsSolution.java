package binarysearch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElementsSolution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0, right = arr.length - k; // 满足最终长度是K，

        List<Integer> list = new ArrayList<>();

        while(left < right) {

            int mid = left + (right - left) / 2;

            if (Math.abs(arr[mid] - x) > Math.abs(arr[mid + k] - x)) { // 比较当前中心点 mid和  mid + k 哪个更小
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        for(int i = left; i < left + k; i++) list.add(arr[i]);

        return list;
    }

    @Test
    public void test() {
        int[] arr = {1,2,3,4,5};
        int k = 4 ;
        int x = -1;
        System.out.println(findClosestElements(arr, k, x).toString());
    }

}
