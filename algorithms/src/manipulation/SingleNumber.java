package manipulation;

import org.junit.Test;

public class SingleNumber {

    @Test
    public void test() {
        int[] nums = {2,2,1};
        System.out.println(singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i : nums) res ^= i;
        return res;
    }
}
