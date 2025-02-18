package org.dsa.examples.arrays;

import utils.ArrayUtils;

public class PartitionArraySmallAndLarge {

  public void solution(int[] arr, int pivot) {

    System.out.println(pivot);
    int i = 0;
    int j = arr.length - 1;
    while (i <= j) {
      if (arr[i] < pivot) {
        i++;
      } else if (arr[j] > pivot) {
        j--;
      } else {
        ArrayUtils.swap(arr, i, j);
        i++;
        j--;
      }
    }
  }
}
