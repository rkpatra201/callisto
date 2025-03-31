package org.dsa.examples.blind75._1arrays;


// https://leetcode.com/problems/maximum-product-subarray/submissions/1583607189/
public class _11MaxProductSubArray {
  public int maxProduct(int[] nums) {
    int max = 1;
    int min = 1;
    int result = nums[0];
    for (int i = 0; i < nums.length; i++) {
      int curr = nums[i];
      if (curr == 0) {
        max = 1;
        min = 1;
        result = Math.max(result, 0);
        continue;
      }

      int curr_max = curr * max;
      int curr_min = curr * min;

      int t_min = Math.min(curr, Math.min(curr_max, curr_min));
      int t_max = Math.max(curr, Math.max(curr_max, curr_min));

      int t_result = Math.max(result, Math.max(t_max, t_min));

      result = t_result;

      min = t_min;
      max = t_max;
    }

    return result;
  }
}
