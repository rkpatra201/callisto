package org.dsa.examples.blind75._3dp;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber/submissions/1601938928/
public class _198HouseRobber1 {
  public int rob(int[] nums) {
    int max = nums[0];
    init(nums.length);
    for (int i = 0; i < nums.length; i++) {
      max = Math.max(max, dfs(nums, i));
    }
    return max;
  }

  public int[] memo = null;

  public void init(int size) {
    memo = new int[size];
    Arrays.fill(memo, -1);
  }

  public int dfs(int[] nums, int index) {
    if (index >= nums.length) {
      return 0;
    }
    if (memo[index] != -1) {
      return memo[index];
    }
    int include = index + 2 > nums.length ? nums[index] : nums[index] + dfs(nums, index + 2);
    int exclude = dfs(nums, index + 1);
    memo[index] = Math.max(include, exclude);
    return memo[index];
  }
}
