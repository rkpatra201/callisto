package org.dsa.examples.arrays;

import utils.ArrayUtils;

public class Sort_0_1_2 {

  public static final int ZERO = 0;
  public static final int TWO = 2;

  public void solution(int[] arr) {
    while (true) {
      int indexTracker_0 = 0;
      int forwardIndex = 0;
      while (forwardIndex < arr.length) {

        int value = arr[forwardIndex];
        if (value == 0) {

          int tempValue = arr[indexTracker_0];
          arr[indexTracker_0] = arr[forwardIndex];
          arr[forwardIndex] = tempValue;

          indexTracker_0++;
        }

        forwardIndex++;
      }

      int indexTracker_2 = arr.length - 1;
      int backwardIndex = arr.length - 1;
      while (backwardIndex >= 0) {

        int value = arr[backwardIndex];
        if (value == 2) {

          int tempValue = arr[indexTracker_2];
          arr[indexTracker_2] = arr[backwardIndex];
          arr[backwardIndex] = tempValue;

          indexTracker_2--;
        }

        backwardIndex--;
      }
      break;
    }
  }

  public void solution_1(int[] arr) {
    int indexTracker_0 = 0;
    int indexTracker_2 = arr.length - 1;

    int index = 0;
    while (index < indexTracker_2) {

      int currentValue = arr[index];
      if (currentValue == ZERO) {

        ArrayUtils.swap(arr, index, indexTracker_0);

        indexTracker_0++;
      }

      if (currentValue == TWO) {
        ArrayUtils.swap(arr, index, indexTracker_2);
        indexTracker_2--;

        if (arr[index] == TWO) {
          continue;
        }
        if (arr[index] == ZERO) {
          continue;
        }
      }

      index++;
    }
  }

}
