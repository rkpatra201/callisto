package org.dsa.examples.v1.dp.stocks;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/1562358095/
public class BuySellStock2 {

  public int solution(int[] prices) {
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        maxProfit += prices[i] - prices[i - 1];
      }
    }
    return maxProfit;
  }
}
