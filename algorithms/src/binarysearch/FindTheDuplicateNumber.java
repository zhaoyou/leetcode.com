package binarysearch;

import org.junit.Test;

/**
 * reference:
 * https://www.cnblogs.com/hiddenfox/p/3408931.html
 * https://www.cnblogs.com/grandyang/p/4843654.html#4198501
 * http://bookshadow.com/weblog/2015/09/28/leetcode-find-duplicate-number/
 * https://leetcode.com/problems/find-the-duplicate-number/discuss/72846/My-easy-understood-solution-with-O(n)-time-and-O(1)-space-without-modifying-the-array.-With-clear-explanation.
 */
public class FindTheDuplicateNumber {

    @Test
    public void test() {
        int[] nums = {2,5,9,6,9,3,8,9,7,1};
//        int[] nums = {3,1,3,4,2};
        System.out.println(findDuplicate2(nums));
    }


    public int findDuplicate(int[] nums) {

        int left = 0, right = nums.length;

        while(left < right) {


            int mid = left + (right - left) / 2;

            int count = 0;

            for(int num: nums) if (num <= mid) count++;

            if (count <= mid) left = mid + 1;
            else right = mid;

        }

        return right;
    }

    /**
     * int[] nums = {3,1,3,4,2};
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {

        int slow = nums[0];
        int fast = nums[slow];

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }


        // 找到会面点，同时，fast 从头开始遍历，再次相遇在环的开始点

        fast = 0;

        while(slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }


//        System.out.println(slow + ":" + fast);

        return slow;



    }
}
