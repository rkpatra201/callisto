package org.dsa.examples.v1.arrays;

public class MinMaxValue {

  public int[] solution(int[] arr) {
    int max = arr[0];
    int min = arr[0];
    for (int i : arr) {
      max = Math.max(max, i);
      min = Math.min(min, i);
    }
    return new int[]{min, max};
  }
}
