package hashtable;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


/**
 * reference:
 * http://www.cnblogs.com/grandyang/p/4656517.html
 * https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation
 */
public class SlidingWindowMaximum {


    @Test
    public void test() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0) return nums;

        int len = nums.length;

        int[] result = new int[len - k + 1];
        int index = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < len; i++) {

            while(!deque.isEmpty() && deque.peek() <= i - k) deque.poll(); // 移除范围内

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();  // 如果范围内索引，小于当前的，也移除掉

            deque.offer(i);

            System.out.println("deque: i: " + i + " peek: " + deque.peek() + "size: " + deque.size());

            if (i >= k - 1) {
                result[index++] = nums[deque.peek()];
            }
        }

        return result;
    }
}
