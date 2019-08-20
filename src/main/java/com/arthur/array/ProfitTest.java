package com.arthur.array;

import org.junit.Test;

public class ProfitTest {

    @Test
    public void testProfit() {
        int[] prices = new int[]{7,6,4,3,1};
        int result = maxProfit(prices);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int sumProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int profit = prices[i + 1] - prices[i];
            if (profit > 0) {
                sumProfit += profit;
            }
        }
        return sumProfit;
    }
}
