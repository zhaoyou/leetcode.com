package bitmanipulation;

import org.junit.Test;

/**
 * 翻转数字的二进制位 前后相互交换
 * reference:
 * https://leetcode.com/problems/reverse-bits/discuss/54738/Sharing-my-2ms-Java-Solution-with-Explanation
 */
public class ReverseBits {

    @Test
    public void test() {
        int n = 1;
        System.out.println(reverseBits(3));
    }


    public int reverseBits(int n) {
        if(n == 0) return 0;

        int result = 0;
        for(int i = 0; i < 32; i++) {
            result <<= 1;               // 结果向左 一位  * 2
            if ((n & 1) == 1) result ++; // 如果需要翻转的位是1，则翻转后也需要+1；
            n >>= 1; // 依次处理原始数据的位数
        }
        return result;
    }
}
