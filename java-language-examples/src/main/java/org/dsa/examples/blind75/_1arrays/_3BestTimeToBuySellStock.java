package org.dsa.examples.blind75.arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/1581459886/
public class _3BestTimeToBuySellStock {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int minPrice = prices[0];
    for (int p : prices) {
      minPrice = Math.min(p, minPrice);
      maxProfit = Math.max(maxProfit, p - minPrice);
    }
    return maxProfit;
  }
}
