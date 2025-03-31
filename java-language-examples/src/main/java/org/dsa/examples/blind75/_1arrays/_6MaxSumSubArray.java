package org.dsa.examples.blind75.arrays;

// https://leetcode.com/problems/maximum-subarray/submissions/1582310000/
public class _6MaxSumSubArray {
  public int maxSubArray(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    int currSum = 0;
    for (int i = 0; i < nums.length; i++) {
      currSum += nums[i];
      maxSum = Math.max(currSum, maxSum); // imp: update maxSum before reset
      if (currSum < 0) {
        currSum = 0;
      }
    }

    return maxSum;
  }
}
