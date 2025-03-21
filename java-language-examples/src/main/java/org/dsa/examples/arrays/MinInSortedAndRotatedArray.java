package org.dsa.examples.arrays;


// https://www.youtube.com/watch?v=IzHR_U8Ly6c
// https://leetcode.com/submissions/detail/1565179092/
public class MinInSortedAndRotatedArray {

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

      // when mid is smaller than its previous element, surely this mid is smallest in array
      if (mid > 0 && nums[mid] < nums[mid - 1]) {
        return nums[mid];
      }

      if (nums[start] <= nums[mid] && nums[mid] > nums[end]) { // left sorted but right is not
        start = mid + 1;
      } else {
        end = mid - 1;
      }

    }
    System.out.println(start);
    System.out.println(end);
    return nums[start];
  }
}
