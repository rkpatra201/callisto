package org.dsa.examples.arrays;

public class MaxSumSubArray {

  public int solution(int[] input) {
    int currSum = 0;
    int maxSum = 0;
    for (int i=0;i<input.length; i++) {
      currSum = currSum + input[i];
      if (currSum < 0) {
        currSum = 0;
      }
      maxSum = Math.max(currSum, maxSum);
    }
    return maxSum;
  }
}
