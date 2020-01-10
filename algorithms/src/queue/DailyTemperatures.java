package queue;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/discuss/109832/Java-Easy-AC-Solution-with-Stack/424012?page=3
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] dp = new int[T.length];

        for(int i = T.length - 1; i >= 0; i--) {
            dp[i] = 0;

            for(int j = i + 1; j < T.length; j++) {
                if (T[i] < T[j]) {
                   // System.out.println(j - i);
                    dp[i] = j - i;
                    break;
                }
            }

            System.out.println(i + ": " + dp[i]);
        }
        return dp;
    }

    public int[] dailyTemperatures2(int[] T) {

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];

        for(int i = 0; i < T.length; i++) {
            while( !stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }

    public int[] dailyTemperatures3(int[] T) {

        int top = -1;
        int[] dp = new int[T.length];
        int[] res = new int[T.length];

        for(int i = 0; i < T.length; i++) {
            while(top > -1 && T[i] > T[dp[top]]) {
                int idx = dp[top--];
                res[idx] = i - idx;
            }
            dp[++top] = i;
        }
        return res;
    }

    @Test
    public void test() {
        int[] T = {55,38,53,81,61,93,97,32,43,78};
        System.out.println(Arrays.toString(dailyTemperatures(T)));
        System.out.println(Arrays.toString(dailyTemperatures2(T)));
        System.out.println(Arrays.toString(dailyTemperatures3(T)));


    }
}
