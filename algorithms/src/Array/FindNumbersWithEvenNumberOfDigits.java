package Array;

import org.junit.Test;

public class FindNumbersWithEvenNumberOfDigits {

    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num: nums) count += (isEven(num) ? 1 : 0);
        return count;
    }

    private boolean isEven(int nums) {
        if (nums > 1 && nums < 10)
            return false;
        else if (nums >= 10 && nums <100 )
            return true;
        else if (nums >= 100 && nums < 1000)
            return false;
        else if (nums >=1000 && nums < 10000)
            return true;
        else if (nums >= 10000 && nums < 100000)
            return false;
        else if (nums >=100000 && nums < 1000000)
            return true;
        else
            return false;
    }

    @Test
    public void test() {
        int [] nums = {555,901,482,1771};
        System.out.println(findNumbers(nums));
    }
}
