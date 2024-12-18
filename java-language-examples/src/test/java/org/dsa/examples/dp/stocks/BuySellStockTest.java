package org.dsa.examples.dp.stocks;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuySellStockTest {

  @Test
  public void solution() {
    int result = 0;
    int[] prices = null;
    int profit = 0;

    prices = new int[]{7, 1, 5, 3, 6, 4};
    profit = 5;
    result = new BuySellStock().solution(prices);
    Assert.assertEquals(profit, result);

    prices = new int[]{7, 6, 4, 3, 1};
    profit = 0;
    result = new BuySellStock().solution(prices);
    Assert.assertEquals(profit, result);

    prices = new int[]{1, 2, 3, 4, 5};
    profit = 4;
    result = new BuySellStock().solution(prices);
    Assert.assertEquals(profit, result);

    prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
    profit = 4;
    result = new BuySellStock().solution(prices);
    Assert.assertEquals(profit, result);

    prices = new int[]{2, 1, 2, 0, 1};
    profit = 1;
    result = new BuySellStock().solution(prices);
    Assert.assertEquals(profit, result);

    prices = new int[]{1, 2, 10, 1, 2};
    profit = 9;
    result = new BuySellStock().solution(prices);
    Assert.assertEquals(profit, result);
  }
}