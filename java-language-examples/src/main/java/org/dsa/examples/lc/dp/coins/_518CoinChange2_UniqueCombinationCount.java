package org.dsa.examples.lc.dp.coins;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.
 */
public class _518CoinChange2_UniqueCombinationCount {
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
