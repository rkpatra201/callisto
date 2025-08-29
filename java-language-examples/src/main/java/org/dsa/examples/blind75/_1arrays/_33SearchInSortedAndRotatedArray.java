package org.dsa.examples.blind75._1arrays;

public class _33SearchInSortedAndRotatedArray {
  public int search(int[] nums, int target) {


    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      if (nums[start] <= nums[mid]) {// 1,2,3,4,5,6,
        // sorted left half
        if (target >= nums[start] && target <= nums[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        // right half sorted
        if (target >= nums[mid] && target <= nums[end]) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }

    }
    return -1;
  }
}
