package org.dsa.examples.v1.dp.stocks;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/submissions/1581523253/
public class BuySellStockTxnFee {

  public int maxProfit(int[] prices, int fee) {
    int maxProfit = 0;
    int minPrice = prices[0];

    for (int i = 1; i < prices.length; i++) {
      minPrice = Math.min(prices[i], minPrice);
      int sp = prices[i] - fee;
      if (sp > minPrice) {
        maxProfit = maxProfit + (sp - minPrice);
        minPrice = sp;
      }
    }
    return maxProfit;
  }

}
