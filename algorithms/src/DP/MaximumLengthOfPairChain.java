package DP;

import org.junit.Test;

import java.util.Arrays;

/**
 * reference: http://www.cnblogs.com/grandyang/p/7381633.html
 */
public class MaximumLengthOfPairChain {


    @Test
    public void test() {
        int[][] pairs = {{1,2}, {1,3}, {2,4}};
        System.out.println(findLongestChain(pairs));
    }

    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> {return a[1] - b[1];});

        int res = 1, prev_end = pairs[0][1];

        int i = 0, len = pairs.length;

        while(i < len) {
            if (pairs[i][0] > prev_end) {
                res++;
                prev_end = pairs[i][1];
            }
            i++;
        }

        return res;
    }
}
