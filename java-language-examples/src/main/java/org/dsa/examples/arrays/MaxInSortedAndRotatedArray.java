package org.dsa.examples.arrays;


public class MaxInSortedAndRotatedArray {

  /**
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
  public int solution(int[] nums) {

    int start = 0;
    int end = nums.length - 1;
    while (start < end) {
      int mid = start + (end - start) / 2;

      if (nums[mid] > nums[end]) {
        // Maximum is in the left half (including mid)
        end = mid;
      } else {
        // Maximum is in the right half
        start = mid + 1;
      }

    }
    System.out.println(start);
    System.out.println(end);
    return nums[start];
  }
}
