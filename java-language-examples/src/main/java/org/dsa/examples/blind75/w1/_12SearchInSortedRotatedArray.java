package org.dsa.examples.blind75.w1;

public class _12SearchInSortedRotatedArray {

  public int search(int[] nums, int target) {

    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      if (nums[start] <= nums[mid]) {// sorted left half

        if (target >= nums[start] && target < nums[mid]) { // when target lies between start and mid
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {// right half sorted

        if (target > nums[mid] && target <= nums[end]) {// when target lies between mid to end
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }

    }
    return -1;
  }
}
