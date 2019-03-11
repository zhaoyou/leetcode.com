package binarysearch;

import org.junit.Test;

/**
 * reference:
 * https://www.cnblogs.com/hiddenfox/p/3408931.html
 * https://www.cnblogs.com/grandyang/p/4843654.html#4198501
 * http://bookshadow.com/weblog/2015/09/28/leetcode-find-duplicate-number/
 */
public class FindTheDuplicateNumber {

    @Test
    public void test() {
        int[] nums = {1,1};
        System.out.println(findDuplicate(nums));
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
}
