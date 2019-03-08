package Sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * reference: http://www.cnblogs.com/grandyang/p/5139057.html
 */
public class WiggleSortII {

    @Test
    public void test() {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void wiggleSort(int[] nums) {

        int len = nums.length;
        int [] temp = new int [len];

        int mid = (len + 1)/2;

        int j = 0;
        for(int i: nums) temp[j++] = i;


        j = len;


        Arrays.sort(temp);

        for(int i = 0; i < len; i++) {
            nums[i] = ((i & 1) == 0) ? temp[--mid] :  temp[--j];
        }

    }
}
