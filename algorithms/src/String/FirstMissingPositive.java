package String;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * reference: https://segmentfault.com/a/1190000006013062 (牛逼算法）
 * 就是一个数组里面的值，如果超过了数组长度， 则遗漏的肯定在这个值的前面
 * 利用桶排序的原理 https://www.youtube.com/watch?v=jfb72FfxWKU
 * 对应位置索引放对应的值
 */
public class FirstMissingPositive {


    @Test
    public void test() {
        int[] nums = {1, 2, 0};
        int[] nums2 = {3, 4, -1, 1};
        int[] nums3 = {7, 9 , 11, 12};
        System.out.println(firstMissingPositive(nums));
        System.out.println(firstMissingPositive(nums2));
        System.out.println(firstMissingPositive(nums3));
    }



    public int firstMissingPositive(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] >= 1) {
                map.put(nums[i], nums[i]);
                if (max < nums[i]) max = nums[i];
            }
        }

        int j = 1;
        while(j < max) {
            if (!map.containsKey(j)) return j;
            j++;
        }

        return max + 1;
    }
}
