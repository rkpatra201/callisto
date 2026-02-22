package org.dsa.examples.lc.sw;

public class _209MinSizeSubArraySum {
  public int minSubArrayLen(int target, int[] nums) {
    int left = 0, sum = 0;
    int minLen = Integer.MAX_VALUE;

    for (int right = 0; right < nums.length; right++) {
      sum += nums[right];

      // Try to shrink window from the left while the sum is valid
      while (sum >= target) {
        minLen = Math.min(minLen, right - left + 1);
        sum -= nums[left++];
      }
    }

    return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
  }
}
