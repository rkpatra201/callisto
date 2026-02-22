package org.dsa.examples.lc.dp.knapsack;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber-ii/submissions/1601936302/
public class _213HouseRobber2 {
  public int rob(int[] nums) {
    int firstMax = nums[0];
    init(nums.length);
    int limit = nums.length - 1;
    for (int i = 0; i < limit; i++) { // 0 to n-2 both inclusive
      firstMax = Math.max(firstMax, dfs(nums, i, limit));
    }

    init(nums.length);
    limit = nums.length;
    int secondMax = nums[0];
    for (int i = 1; i < limit; i++) { // 1 to n-1 both inclusive
      secondMax = Math.max(secondMax, dfs(nums, i, limit));
    }
    return Math.max(firstMax, secondMax);
  }

  public int[] memo = null;

  public void init(int size) {
    memo = new int[size];
    Arrays.fill(memo, -1);
  }

  public int dfs(int[] nums, int index, int lastIndex) {
    if (index >= lastIndex) {
      return 0;
    }
    if (memo[index] != -1) {
      return memo[index];
    }
    int include = index + 2 > lastIndex ? nums[index] : nums[index] + dfs(nums, index + 2, lastIndex);
    int exclude = dfs(nums, index + 1, lastIndex);
    memo[index] = Math.max(include, exclude);
    return memo[index];
  }
}
