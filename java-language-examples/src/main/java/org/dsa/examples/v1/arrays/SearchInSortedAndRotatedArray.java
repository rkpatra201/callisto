package org.dsa.examples.v1.arrays;


public class SearchInSortedAndRotatedArray {

  /**
   * https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/1490019665/
   *
   * In a sortedAndRotated array when we divide. 2 things can happen
   * 1. start - mid (sorted) , mid - end (unsorted)
   * 2. start - mid (unsorted), min - end (sorted)
   * <p>
   * That means always we must have a sorted part and unsorted part.
   *
   * @param nums
   * @param target
   * @return
   */
  public int solution(int[] nums, int target) {

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
