package Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * reference:
 * http://www.cnblogs.com/grandyang/p/4603555.html
 */
public class SummaryRanges {

    @Test
    public void test() {
        int[] nums = {0,1,2,3,4,5,6,7};
        System.out.println(summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int len = nums.length;
        for(int i = 0; i < len; i++) {

            int j = 1;

            while (i + j < len && nums[i + j] - nums[i] == j) {
                j++;
            }

            if (j <= 1) {
                list.add(nums[i] + "");
            } else {
                list.add(nums[i] + "->" + nums[i + j - 1]);
                i += j - 1;
            }
        }
        return  list;
    }
}
