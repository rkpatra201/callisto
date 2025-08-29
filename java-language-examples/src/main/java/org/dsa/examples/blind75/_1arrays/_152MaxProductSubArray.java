package org.dsa.examples.blind75._1arrays;


// https://leetcode.com/problems/maximum-product-subarray/submissions/1583607189/
public class _152MaxProductSubArray {
  public int maxProduct(int[] nums) {
    int min = nums[0];
    int max = nums[0];
    int result = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int v = nums[i];
      if (v < 0) {
        int t = min;
        max = min;
        min = t;
      }

      min = Math.min(v, min * v);
      max = Math.max(v, max * v);
      result = Math.max(result, max);
    }

    return result;
  }
}
