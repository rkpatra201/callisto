package org.dsa.examples.dp.stairs;

import java.util.Arrays;

// https://leetcode.com/problems/climbing-stairs/submissions/1577538330/
public class ClimbingStairs1 {
  private int[] memo = null;

  public int climbStairs(int n) {
    if (memo == null) {
      memo = new int[n + 1];
      Arrays.fill(memo, -1);
    }

    if (n == 0) {
      return 1;
    }

    if (n < 0) {
      return 0;
    }

    if (memo[n] != -1) {
      return memo[n];
    }

    memo[n] = climbStairs(n - 1) + climbStairs(n - 2);

    return memo[n];
  }
}
