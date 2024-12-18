package org.dsa.examples.dp.stocks;

public class BuySellStock2 {

  public int solution(int[] prices){
    int max=prices[0];
    int min=prices[0];
    int totalProfit = 0;
    int profit = 0;
    for(int i=0; i< prices.length; i++){
      profit = Math.max(profit, max - min);
      int tempMin = Math.min(max, prices[i]);
      if(tempMin < max){
        min = tempMin;
        max = tempMin;
        totalProfit = totalProfit + profit;
        profit = 0;
        continue;
      }
      max = Math.max(max, prices[i]);
    }
    profit = Math.max(profit, max - min);
    return totalProfit + profit;
  }
}
