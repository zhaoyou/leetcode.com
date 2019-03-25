package interviewEasy.Array;

import org.junit.Test;

public class BestTimeToBuyAndSellStockII {

    @Test
    public void test() {
        int [] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }


    public int maxProfit(int[] prices) {
        int len = prices.length;

        int total = 0;

        for(int i = 0; i < len - 1;i ++) {
            if (prices[i + 1] > prices[i]) total += prices[i + 1] - prices[i];
        }

        return total;
    }
}
