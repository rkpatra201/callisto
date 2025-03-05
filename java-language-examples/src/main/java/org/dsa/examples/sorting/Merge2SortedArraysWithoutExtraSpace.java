package org.dsa.examples.arrays;

import java.util.Arrays;

public class Merge2SortedArraysWithoutExtraSpace {
  /**
   * 1, 3, 5, 8
   * 4, 7
   * <p>
   * 1, 3, 4, 5
   * 7, 8
   *
   * @param arr1
   * @param arr2
   */
  public void solution(int[] arr1, int[] arr2) {
    if (arr1[0] > arr2[0]) {
      int[] temp = arr1;
      arr1 = arr2;
      arr2 = temp;
      solution(arr1, arr2);
    }

    int right_first = arr1.length - 1; // it starts from the last of first array
    int left_second = 0; // it starts from the beginning of second array

    /**
     * If any larger elements are present in first array should go to second array.
     * If any small elements are present in second array should go to first array.
     *
     * Now arr1 and arr2 no more in sorted nature. At the end we have to do the sorting.
     *  keep swapping elements between arr1 and arr2
     *  using the index {@link right_first} and {@link left_second}
     */

    while (right_first >= 0 && left_second < arr2.length - 1) {

      if (arr1[right_first] > arr2[left_second]) {
        // swapping logic
        int value = arr1[right_first];
        arr1[right_first] = arr2[left_second];
        arr2[left_second] = value;

      }
      right_first--;
      left_second++;
    }

    Arrays.sort(arr1);
    Arrays.sort(arr2);

  }
}
