package org.dsa.examples.lc.dp.sequence;

import java.util.Arrays;

public class _300LengthOfLIS {
  // similar to problem number 320
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    visited = new boolean[n];
    initMemo(n);
    int maxLen = 0;
    for (int i = 0; i < n; i++) {
      maxLen = Math.max(maxLen, dfs(i, nums, Integer.MIN_VALUE));
    }
    return maxLen;
  }

  private int[] memo = null;

  private void initMemo(int n) {
    memo = new int[n];
    Arrays.fill(memo, -1);
  }

  boolean visited[] = null;

  private int dfs(int index, int[] nums, int prev) {

    boolean valid = index < nums.length
        && prev < nums[index];
    // && !visited[index]; // not reuired as we may not explore this index in the current recursion flow again

    if (!valid) {
      return 0;
    }

    if (memo[index] != -1) {
      return memo[index];
    }

    //  visited[index] = true;

    int v = nums[index];
    int levelMax = 0;
    int newIndex = index + 1;
    while (newIndex < nums.length) {
      levelMax = Math.max(levelMax, dfs(newIndex, nums, v));
      newIndex++;
    }

    visited[index] = false;
    memo[index] = 1 + levelMax;

    return memo[index];

  }
}
