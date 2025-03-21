package org.dsa.examples.dp.stocks;

// max 1 txn allowed
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/1562350970/
public class BuySellStock1 {

  public int solution(int[] prices) {
    int maxProfit = 0;
    int minPrice = prices[0];
    for (int currentPrice : prices) {
      minPrice = Math.min(currentPrice, minPrice);
      maxProfit = Math.max(maxProfit, currentPrice - minPrice);
    }
    return maxProfit;
  }
}
