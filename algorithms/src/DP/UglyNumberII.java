package DP;

import org.junit.Test;

import java.util.*;

/**
 * reference: http://www.cnblogs.com/grandyang/p/4743837.html
 */

/**
 * 动态规划版本
 * class Solution {
 *     public int nthUglyNumber(int n) {
 *         int i2=0;
 *         int i3=0;
 *         int i5=0;
 *
 *         int f2=2;
 *         int f3=3;
 *         int f5=5;
 *
 *         int dp[]=new int[n];
 *         dp[0]=1;
 *
 *         for(int i=1;i<n;i++){
 *             int min=Math.min(Math.min(f2,f3),f5);
 *             dp[i]=min;
 *
 *             if(min==f2){
 *                 f2=dp[++i2]*2;
 *             }
 *
 *             if(min==f3){
 *                 f3=dp[++i3]*3;
 *             }
 *
 *             if(min==f5){
 *                 f5=dp[++i5]*5;
 *             }
 *         }
 *
 *         return dp[n-1];
 *     }
 * }
 */
public class UglyNumberII {

    @Test
    public void test() {
        int n = 414;
        System.out.println("the " + n + " nthUglyNumber: " + nthUglyNumber2(n));
    }

    public int nthUglyNumber(int n) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap();

        int i = 1;

        while(stack.size() < n) {

            if (isUgly(i, map)) {
                stack.push(i);
                map.put(i, i);
            }
            i++;
        }

        return  stack.pop();
    }

    public int nthUglyNumber2(int n) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        int index2 = 0, index3 = 0, index5 = 0;

        while(list.size() < n) {
            int m2 = list.get(index2) * 2, m3 = list.get(index3) * 3, m5 = list.get(index5) * 5;

            int min = Math.min(m2, Math.min(m3, m5));

            if (min == m2) index2 ++;
            if (min == m3) index3 ++;
            if (min == m5) index5 ++;

            list.add(min);
        }

        return  list.get(n - 1);
    }

    private boolean isUgly(int num, Map<Integer, Integer> map) {

        if (num <= 0) return false;
        if (num == 1) return true;


        System.out.println("map size: " + map.size());
        if (map.containsKey(num)) return true;

        if (num % 2 == 0) return isUgly( num / 2, map);
        else if (num % 3 == 0) return isUgly( num / 3, map);
        else if (num % 5 == 0) return isUgly(num / 5, map);

        return false;
    }
}
