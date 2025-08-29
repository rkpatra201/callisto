package org.dsa.examples.blind75._1arrays;

// https://leetcode.com/problems/product-of-array-except-self/submissions/1582454713/
public class _238ProductOfArrayExceptElement {

  public int[] productExceptSelf(int[] nums) {
    int[] prefix = new int[nums.length];
    int[] suffix = new int[nums.length];
    int[] result = new int[nums.length];

    prefix[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      prefix[i] = prefix[i - 1] * nums[i - 1];
    }

    suffix[nums.length - 1] = 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      suffix[i] = suffix[i + 1] * nums[i + 1];
    }

    for (int i = 0; i < nums.length; i++) {
      result[i] = prefix[i] * suffix[i];
    }
    return result;
  }

}
