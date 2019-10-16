package binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        if (nums1.length == 0 || nums2.length == 0) return new int[0];

        List<Integer> list = new LinkedList<>();

        for(int i: nums1) map1.put(i, i);
        for(int j: nums2) map2.put(j, j);

        if (map1.size() > map2.size()) {
            for(int key: map2.keySet()) {
                if (map1.containsKey(key)) list.add(key);
            }
        } else {
            for(int key: map1.keySet()) {
                if (map2.containsKey(key)) list.add(key);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m == 0 || n == 0) return new int[0];

        int i = 0, j = 0, k = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] result = new int[Math.min(m, n)];

        while(i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {

                if (k == 0 || result[k-1] != nums1[i]) {
                    result[k] = nums1[i];
                    k++;
                }
                i++;
                j++;
            }
        }

        int[] oo = new int[k];

        for(i = 0; i < k;i++) {
            oo[i] = result[i];
        }
        return oo;
    }
}
