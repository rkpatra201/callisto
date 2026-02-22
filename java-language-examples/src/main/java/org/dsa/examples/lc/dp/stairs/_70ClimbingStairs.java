package org.dsa.examples.lc.dp.stairs;

import java.util.Arrays;

public class _70ClimbingStairs {

  private int[] memo = null;

  public int climbStairs(int n) {
    return dfs(0, n);
  }

  private int dfs(int start, int n){
    if (memo == null) {
      memo = new int[n + 1];
      Arrays.fill(memo, -1);
    }

    if (start == n) {
      return 1;
    }

    if (start > n) {
      return 0;
    }

    if (memo[start] != -1) {
      return memo[start];
    }

    memo[start] = dfs(start + 1, n) + dfs(start + 2, n);

    return memo[start];
  }
}
