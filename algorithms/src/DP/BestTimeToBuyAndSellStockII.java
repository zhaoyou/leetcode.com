package DP;

import org.junit.Test;

/**
 * 这道题没有理解清楚，如果前一天是买进，当天可以卖出，也可以买进，后面再卖出。
 */
public class BestTimeToBuyAndSellStockII {

    @Test
    public void test() {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }


    public int maxProfit(int[] prices) {

        if (prices.length < 2) return 0;

        int len = prices.length;

        int total = 0;

        for(int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) total += prices[i] - prices[i - 1];
        }
        return total;
    }
}
