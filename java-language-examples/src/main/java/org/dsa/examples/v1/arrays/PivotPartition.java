package org.dsa.examples.v1.arrays;

import utils.ArrayUtils;


public class PivotPartition {


  /**
   * single pointer approach:
   * <p>
   * Take last element as pivot.
   * <p>
   * start = 0;
   * end = nums.length - 1
   * pivotIndex = end
   * the pivot = arr[pivotIndex]
   * <p>
   * And a tracker for elements less than pivot value.
   * Let say tracker index is : pivotTrackerIndex
   * <p>
   * Now we will traverse between start and end -1 (inclusive)
   * We check if current value is less than the pivot
   * then swap start and pivotTrackerIndex
   * and increment pivotTrackerIndex
   *
   * @param nums
   */
  public void solution(int[] nums) {
    int start = 0;
    int end = nums.length - 1;
    int pivotIndex = end;
    int pivot = nums[pivotIndex];
    int pivotTrackerIndex = 0;
    while (start <= end - 1) {
      if (nums[start] < pivot) {
        int t = nums[start];
        nums[start] = nums[pivotTrackerIndex];
        nums[pivotTrackerIndex] = t;
        pivotTrackerIndex++;
      }
      start++;
    }

    // swap pivot index with pivot tracker
    // all elements below pivotTrackerIndex are less than pivot value
    ArrayUtils.swap(nums, pivotTrackerIndex, pivotIndex);

  }

  /**
   * Two pointer approach:
   * <p>
   * Take last element as pivot. And its index say end or pivotIndex.
   * Now we have to traverse from the start to end-1(inclusive)
   * - increment start when we see value less than pivot
   * - decrement end when we see value greater than pivot
   * - swap start and end otherwise then increment start & decrement end.
   * <p>
   * At the end swap start with pivotIndex.
   * <p>
   * The pivot value will be seen at start now.
   * left elements < pivot < right elements
   *
   * @param nums
   */
  public void solution1(int[] nums) {
    int start = 0;
    int end = nums.length - 1;
    int pivotIndex = end;
    int pivot = nums[pivotIndex];
    while (start <= end - 1) {
      if (nums[start] < pivot) {
        start++;
      } else if (nums[end] > pivot) {
        end--;
      } else {
        ArrayUtils.swap(nums, start, end);
        start++;
        end--;
      }
    }
    ArrayUtils.swap(nums, start, pivotIndex);
  }
}
