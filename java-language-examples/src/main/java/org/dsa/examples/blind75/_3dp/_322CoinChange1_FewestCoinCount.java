package org.dsa.examples.blind75._3dp;


import java.util.Arrays;

// https://leetcode.com/problems/coin-change/submissions/1597838077/
public class _322CoinChange1_FewestCoinCount {
  public int coinChange(int[] coins, int amount) {
    memo = new int[amount + 1];
    Arrays.fill(memo, -2); // -2 means unvisited, -1 = not possible
    return dfs(coins, amount);
  }

  private int[] memo;

  private int dfs(int[] coins, int amount) {
    if (amount == 0) return 0;
    if (amount < 0) return -1;
    if (memo[amount] != -2) return memo[amount];

    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
      int res = dfs(coins, amount - coin);
      if (res != -1) {
        min = Math.min(min, res);
      }
    }

    memo[amount] = (min == Integer.MAX_VALUE) ? -1 : min + 1; // added 1 for current coin
    return memo[amount];
  }
}
