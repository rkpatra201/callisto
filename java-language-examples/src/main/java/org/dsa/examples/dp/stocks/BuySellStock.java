package org.dsa.examples.dp.stocks;

public class BuySellStock {

  public int solution(int[] prices){
    int max=prices[0];
    int min=prices[0];
    int maxProfit = 0;
    for(int i=0; i< prices.length; i++){
      maxProfit = Math.max(maxProfit, max - min);
      int tempMin = Math.min(min, prices[i]);
      if(tempMin < min){
        min = tempMin;
        max = tempMin;
        continue;
      }
      max = Math.max(max, prices[i]);
    }
    maxProfit = Math.max(maxProfit, max - min);
    return maxProfit;
  }
}
