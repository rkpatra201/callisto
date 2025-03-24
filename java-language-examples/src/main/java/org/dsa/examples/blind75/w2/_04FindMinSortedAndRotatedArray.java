package org.dsa.examples.blind75.w2;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/1584692330/
public class _04FindMinSortedAndRotatedArray {

  public int findMin(int[] nums) {

    int l = 0;
    int r = nums.length - 1;

    while (l <= r) {
      int m = l + (r - l) / 2;

      if (m > 0 && nums[m - 1] > nums[m]) {
        return nums[m];
      }

      if (nums[l] <= nums[m] && nums[m] > nums[r]) { // left part sorted so search in right half, so adjusting left pointer
        l = m + 1;
      } else {
        r = m - 1;
      }
    }

    return nums[l];
  }
}
