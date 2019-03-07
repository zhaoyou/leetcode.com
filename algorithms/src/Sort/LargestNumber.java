package Sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;


/**
 * reference: https://leetcode.com/problems/largest-number/discuss/53158/My-Java-Solution-to-share
 */
public class LargestNumber {

    @Test
    public void test() {
        int[] nums = {10, 2, 1, 0};
        System.out.println(largestNumber(nums));
    }


    public String largestNumber(int[] nums) {
        String[] nums_str = new String[nums.length];
        int j = 0;
        for(int i : nums) nums_str[j++] = String.valueOf(i);

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };

        Arrays.sort(nums_str, comparator);

        if (nums_str[0].charAt(0) == '0') return "0";

        StringBuffer sb = new StringBuffer("");

        for(String s: nums_str) sb.append(s);

        return sb.toString();
    }
}
