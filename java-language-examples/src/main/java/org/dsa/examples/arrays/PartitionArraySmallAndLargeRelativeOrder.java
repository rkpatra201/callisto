package org.dsa.examples.arrays;

import utils.ArrayUtils;

/**
 * this does the partition but never keeps the relative order of elements
 * <p>
 * we need relative order of elements with constant space: o(1) and
 * time complexity : o(n)
 *
 * But constant space not possible and we took a separate array
 */
public class PartitionArraySmallAndLargeRelativeOrder {

  public int[] pivotArray(int[] nums, int pivot) {
    return solution(nums, pivot);

  }

  public int[] solution(int[] nums, int pivot) {

    System.out.println(pivot);
    int i = 0;
    int j = nums.length - 1;
    int left = 0;
    int right = nums.length - 1;
    int[] result = new int[nums.length];
    while (i < nums.length && j >= 0) {
      int v1 = nums[i];
      int v2 = nums[j];
      if (v1 < pivot) {
        result[left++] = v1;
      }

      if (v2 > pivot) {
        result[right--] = v2;
      }

      i++;
      j--;
    }

    while (left <= right) {
      result[left++] = pivot;
    }


    return result;

  }

}
