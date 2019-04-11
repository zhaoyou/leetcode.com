package interviewMedium.sortAndsearch;

import org.junit.Test;

/**
 * Reference:
 * https://www.youtube.com/watch?time_continue=15&v=a7D77DdhlFc
 */
public class FindPeakElement {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {

        if (nums.length == 1) return 0;

        int left = 0, right = nums.length - 1;

        while(left <= right) {


            int mid = (left + right )/2;


            if ((mid > 0 &&nums[mid] > nums[mid -1]) && (mid < nums.length - 1 && nums[mid] > nums[mid + 1])) {
                return mid;
            } else if  (mid > 0 && nums[mid -1] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
