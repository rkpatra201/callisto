package org.dsa.examples.v1.arrays;

public class SubArraySum {

  // sliding window
  public int[] solution(int[] arr, int sum) {
    int startIndex = 0;
    int endIndex = 0;
    int currentSum = 0;
    for (int i = 0; i < arr.length; i++) {

      while (currentSum > sum) {
        currentSum = currentSum - arr[startIndex];
        startIndex++;
      }

      if (currentSum == sum) {
        break;
      }

      currentSum = currentSum + arr[i];
      endIndex++;
    }
    return new int[]{startIndex, endIndex};
  }
}
