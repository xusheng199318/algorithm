package com.arthur.dynamic;

import org.junit.Test;

public class MaxProfit {

    @Test
    public void testMaxProfit() {
        int[] prices = new int[] {7,1,5,3,6,4};
        int result = maxProfit(prices);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
