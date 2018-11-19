package String;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.
 *
 * Example 1:
 *
 * Input: 12
 * Output: 21
 *
 *
 * Example 2:
 *
 * Input: 21
 * Output: -1
 *
 *
 */

/**
 * reference: http://massivealgorithms.blogspot.com/2017/04/leetcode-556-next-greater-element-iii.html
 */
public class NextGreaterElementIII {

    @Test
    public void test() {
        int n = 165432;
        System.out.println(n + " -> " + nextGreaterElement(n));
    }


    public int nextGreaterElement(int n) {

        String s = String.valueOf(n);

        char[] c = s.toCharArray();

        int left = new Integer( c[c.length - 1] + "");

        int i = c.length - 1;

        int min_value  = 10;
        int min_index = c.length - 1;

        for(; i >= 0; i--) {
            int num = new Integer(c[i] + "");
            if (num < left) break;  // 找对第一个递减的数据 n。
            left = num;
        }

        if (i == -1) return -1;



        for(int j = c.length - 1; j > i; j--) {
            if (c[j] > c[i]) {

                int num = new Integer(c[j] + "");

                //System.out.println(num + "  ======== " + min_value);

                if (num < min_value) {  // 找到右边大于n的最小的书
                    min_value = num;
                    min_index = j;
                }
            }
        }

        char temp = c[i];
        c[i] = String.valueOf(min_value).charAt(0);
        c[min_index] = temp;

        //System.out.println("i: " + i + " min_index " + min_index);

        sort(c, i + 1, c.length);

        try {
            return Integer.parseInt(new String(c));
        } catch (Exception e) {
            return -1;
        }

    }

    private void sort(char[] source, int start, int end) {
        for(int i = start; i < end; i++)
            for(int j = i + 1; j < end; j++) {
                if (source[i] > source[j]) {
                    char temp = source[i];
                    source[i] = source[j];
                    source[j] = temp;
                }
            }
    }
}
