package org.dsa.examples.arrays;

public class NegativeElementsToLeft {

  public void solution(int[] arr) {
    int indexTracker = 0;
    int index = 0;
    while (index < arr.length) {

      int value = arr[index];
      if (value < 0) {

        int tempValue = arr[indexTracker];
        arr[indexTracker] = arr[index];
        arr[index] = tempValue;

        indexTracker++;
      }

      index++;
    }
  }

}
