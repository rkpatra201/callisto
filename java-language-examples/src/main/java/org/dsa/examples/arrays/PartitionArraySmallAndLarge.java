package org.dsa.examples.arrays;

import utils.ArrayUtils;

/**
 * this does the partition but never keeps the relative order of elements
 *
 * we need relative order of elements with constant space: o(1) and
 * time complexity : o(n)
 */
public class PartitionArraySmallAndLarge {

  public void solution(int[] arr, int pivot) {

    System.out.println(pivot);
    int i = 0;
    int j = arr.length - 1;
    int pivotLeft = 0;
    int pivotRight = arr.length - 1;

    while (i <= pivotRight) {
      if (arr[i] < pivot) {
        ArrayUtils.swap(arr, i, pivotLeft);
        i++;
        pivotLeft++;
      } else if (arr[i] > pivot) {
        ArrayUtils.swap(arr, i, pivotRight);
        pivotRight--;
      } else {
        i++;
      }
    }

  }


}
