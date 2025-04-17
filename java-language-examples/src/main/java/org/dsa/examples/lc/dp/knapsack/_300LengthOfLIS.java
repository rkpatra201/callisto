package org.dsa.examples.lc.dp.knapsack;

import java.util.Arrays;

public class _300LengthOfLIS {
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    visited = new boolean[n];
    initMemo(n);
    int maxLen = 0;
    for (int i = 0; i < n; i++) {
      maxLen = Math.max(maxLen, dfs(i, nums, -1));
    }
    return maxLen;
  }

  private int[] memo = null;

  private void initMemo(int n) {
    memo = new int[n];
    Arrays.fill(memo, -1);
  }

  boolean visited[] = null;

  private int dfs(int index, int[] nums, int prevIndex) {
    if (index == nums.length) {
      return 0;
    }
    if (memo[index] != -1) {
      return memo[index];
    }
    // Don't take current number
    int exclude = dfs(index + 1, nums, prevIndex);

    // Take current number if it's larger than prev
    int include = 0;
    if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
      include = 1 + dfs(index + 1, nums, index);
    }

    memo[index] = Math.max(include, exclude);

    return memo[index];
  }
}
