package org.dsa.examples.lc.dp.sum;

import java.util.Arrays;

// https://leetcode.com/problems/combination-sum-iv/submissions/1594018138/
public class _377CombinationPrint4 {
  private int[] memo = null;

  private void init(int target) {
    if (memo != null) {
      return;
    }
    memo = new int[target + 1];
    Arrays.fill(memo, -1);
  }

  public int combinationSum4(int[] nums, int target) {
    init(target);
    if (target == 0) {
      return 1;
    }
    if (target < 0) {
      return 0;
    }

    if (memo[target] != -1) {
      return memo[target];
    }

    int totalWays = 0;
    for (int i : nums) {
      int t = target - i;
      totalWays += combinationSum4(nums, t);
    }
    memo[target] = totalWays;
    return totalWays;
  }
}
