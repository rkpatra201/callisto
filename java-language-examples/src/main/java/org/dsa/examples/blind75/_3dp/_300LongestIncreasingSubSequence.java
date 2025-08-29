package org.dsa.examples.blind75._3dp;

import java.util.Arrays;

// https://leetcode.com/problems/longest-increasing-subsequence/submissions/1596176319/
public class _300LongestIncreasingSubSequence {
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] memo = new int[n];
    Arrays.fill(memo, -1);

    int maxLen = 0;
    for (int i = 0; i < n; i++) {
      maxLen = Math.max(maxLen, dfs(i, nums, memo));
    }
    return maxLen;
  }

  private int dfs(int index, int[] nums, int[] memo) {
    if (memo[index] != -1) return memo[index];

    int max = 1; // At least the current number is counted
    for (int next = index + 1; next < nums.length; next++) {
      if (nums[next] > nums[index]) {
        int subBranchResult = 1 + dfs(next, nums, memo);
        max = Math.max(max, subBranchResult);
      }
    }

    memo[index] = max;
    return max;
  }
}
