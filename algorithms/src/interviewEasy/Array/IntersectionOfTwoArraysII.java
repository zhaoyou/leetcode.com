package interviewEasy.Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntersectionOfTwoArraysII {

    @Test
    public void test(){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList();

        int i = 0, j = 0;

        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

       // int[]a = new int[list.size()];
        int[] a = new int[list.size()];
        for(int k = 0; k < list.size(); k++) {
            a[k] = list.get(k);
        }


        return a;
    }
}
