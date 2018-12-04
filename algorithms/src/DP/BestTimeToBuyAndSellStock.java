package DP;

import org.junit.Test;

/**
 * reference: http://www.cnblogs.com/grandyang/p/4280131.html
 *
 */
public class BestTimeToBuyAndSellStock {

    @Test
    public void test() {
        int[] prices = {1,3,2,7};
        System.out.println(maxProfit2(prices));
    }

    public int maxProfit(int[] prices) {

        if (prices.length < 2) return 0;

        int len = prices.length;

        int max = 0;

        for (int i = 0; i < len; i++) {
            for(int j = i + 1; j < len && prices[j] > prices[i]; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }

        return max;
    }

    public int maxProfit2(int[] prices) {
        int res = 0, buy = Integer.MAX_VALUE;
        for (int price : prices) {
            buy = Math.min(buy, price);
            res = Math.max(res, price - buy);
        }
        return res;
    }
}
