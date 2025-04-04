package org.dsa.examples.v1.arrays;

public class ReverseArray {

  public void solution(int[] arr) {
    int startIndex = 0;
    int endIndex = arr.length - 1;
    int length = endIndex;

    while (startIndex <= length / 2) {

      int swapValue = arr[endIndex];
      arr[endIndex] = arr[startIndex];
      arr[startIndex] = swapValue;

      startIndex++;
      endIndex--;
    }

  }


}
