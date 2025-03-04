package org.dsa.examples.dp.stocks;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/1562350970/
public class BuySellStock1 {

  public int solution(int[] prices) {
    int maxProfit = 0;
    int minPrice = prices[0];
    for (int p : prices) {
      minPrice = Math.min(p, minPrice);
      maxProfit = Math.max(maxProfit, p - minPrice);
    }
    return maxProfit;
  }
}
