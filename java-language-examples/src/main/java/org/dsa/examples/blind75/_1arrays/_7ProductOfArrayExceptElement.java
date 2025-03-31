package org.dsa.examples.blind75.arrays;

// https://leetcode.com/problems/product-of-array-except-self/submissions/1582454713/
public class _7ProductOfArrayExceptElement {

  public int[] productExceptSelf(int[] nums) {
    int prefix[] = new int[nums.length];
    int suffix[] = new int[nums.length];

    prefix[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      prefix[i] = prefix[i - 1] * nums[i];
    }
    suffix[nums.length - 1] = nums[nums.length - 1];
    for (int i = nums.length - 2; i >= 0; i--) {
      suffix[i] = suffix[i + 1] * nums[i];
    }

    // System.out.println(Arrays.toString(prefix));
    //System.out.println(Arrays.toString(suffix));

    /**
     [1, 2, 6, 24]
     [24, 24, 12, 4]
     */
    int result[] = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      int prefixIndex = i - 1;
      int suffixIndex = i + 1;

      int prefixVal = 1;
      int suffixVal = 1;

      if (prefixIndex >= 0) {
        prefixVal = prefix[prefixIndex];
      }

      if (suffixIndex < nums.length) {
        suffixVal = suffix[suffixIndex];
      }

      result[i] = prefixVal * suffixVal;
    }

    return result;
  }

}
