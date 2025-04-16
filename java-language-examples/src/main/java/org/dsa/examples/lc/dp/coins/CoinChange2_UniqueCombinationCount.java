package org.dsa.examples.lc.dp.coins;

public class CoinChange2_UniqueCombinationCount {
  public int change(int amount, int[] coins) {
    // Initialize memo with -1 (uncomputed)
    Integer[][] memo = new Integer[coins.length][amount + 1];
    return change(amount, coins, 0, memo);
  }

  private int change(int amount, int[] coins, int index, Integer[][] memo) {
    if (amount == 0) {
      return 1;
    }

    if (amount < 0 || index == coins.length) {
      return 0;
    }

    if (memo[index][amount] != null) {
      return memo[index][amount];
    }

    // Include the coin (do not move index)
    int include = change(amount - coins[index], coins, index, memo);

    // Exclude the coin (move to next coin)
    int exclude = change(amount, coins, index + 1, memo);

    memo[index][amount] = include + exclude;
    return memo[index][amount];
  }
}
