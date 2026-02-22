package org.dsa.examples.v1.arrays;

public class BinarySearch {

  /**
   * 1,2,3,4,5,6,7,8
   * <p>
   * start = 0
   * end = 7
   * mid = (start + end ) / 2 = 3
   * 4 == 8
   * <p>
   * start = 4
   * end = 7
   * mid = 5
   * 6 == 8
   * <p>
   * start = 6
   * end = 7
   * mid = 6
   * 7 == 8
   * <p>
   * start = 7
   * end = 7
   * mid = 7
   * 8 == 8
   */
  public int solution(int[] arr, int searchItem) {
    int startIndex = 0;
    int endIndex = arr.length - 1;
    int searchItemIndex = -1;

    while (startIndex <= endIndex) {

      int midIndex = (startIndex + endIndex) / 2;
      int midIndexValue = arr[midIndex];

      if (searchItem == midIndexValue) {
        searchItemIndex = midIndex;
        break;
      }

      if (midIndexValue < searchItem) {
        startIndex = midIndex + 1;
      }

      if (searchItem < midIndexValue) {
        endIndex = midIndex - 1;
      }
    }
    return searchItemIndex;
  }
}
