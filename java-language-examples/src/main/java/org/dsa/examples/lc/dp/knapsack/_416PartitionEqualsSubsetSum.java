package org.dsa.examples.lc.dp.knapsack;

import java.util.stream.IntStream;

public class _416PartitionEqualsSubsetSum {
  public boolean canPartition(int[] nums) {
    int sum = IntStream.of(nums).sum();
    if (sum % 2 == 1) {
      return false;
    }
    int targetSum = sum / 2;
    memo = new Boolean[nums.length][targetSum + 1];
    System.out.println(targetSum);
    return dfs(nums, 0, targetSum);
    //return false;
  }

  private Boolean[][] memo = null;

  private boolean dfs(int[] nums, int index, int targetSum) {
    if (targetSum == 0) {
      return true;
    }
    if (targetSum < 0) {
      return false;
    }
    if (index > nums.length - 1) {
      return false;
    }

    if (memo[index][targetSum] != null) {
      return memo[index][targetSum];
    }
    boolean include = dfs(nums, index + 1, targetSum - nums[index]);
    boolean exclude = dfs(nums, index + 1, targetSum);

    boolean result = include || exclude;
    memo[index][targetSum] = result;
    return result;
  }
}
