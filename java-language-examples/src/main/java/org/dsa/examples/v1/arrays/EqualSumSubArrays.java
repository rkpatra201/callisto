package org.dsa.examples.v1.arrays;

public class EqualSumSubArrays {

  public static int[][] solution(int[] arr) {

    int leftSum = 0;
    int rightSum = 0;
    for (int i : arr) {
      leftSum = leftSum + i;
    }

    int splitIndex = -1;
    for (int i = arr.length - 1; i >= 0; i--) {
      rightSum = rightSum + arr[i];
      leftSum = leftSum - arr[i];
      if (leftSum == rightSum) {
        splitIndex = i;
        break;
      }
    }

    int[] leftArr = new int[arr.length];
    for(int i=0; i<splitIndex; i++){
      leftArr[i] = arr[i];
    }

    int[] rightArr = new int[arr.length];
    for(int i=splitIndex; i!=-1 && i < arr.length; i++){
      rightArr[i] = arr[i];
    }

    return new int[][]{leftArr, rightArr};
  }

}
