package interviewMedium.sortAndsearch;

import org.junit.Test;

import java.util.Arrays;

public class SearchForARange {

    @Test
    public void test() {
        int nums[] = {5,7,7,8,8,10};
        int target = 6;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length;
        while(left < right) {
            int mid = left + (right - left)/2;
            System.out.println("mid: " + mid + " value: " + nums[mid]);
            if (nums[mid] == target) {

                System.out.println("mid: " + mid + " nums[mid]: " + nums[mid]);
                //return new int[]{mid, mid + 1};

                int k = mid-1;
                while(k >= 0) {
                    if (nums[k] == target) {k--; continue;}

                    break;
                }
//
                int j = mid+1;
                while(j < nums.length) {
                    if (nums[j] == target){j++; continue;}
                    break;
                }

                System.out.println("FIND....");

                return new int[]{k + 1, j - 1};

            } else if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }

        System.out.println(left + ": " + right);

        return new int[]{-1, -1};
    }
}
