package org.dsa.examples.v1.arrays;

import utils.ArrayUtils;

import java.util.Arrays;

public class RotateArrayByK {

  public void solution(int[] arr, int k) {
    reverse(arr);
    System.out.println(Arrays.toString(arr));
    ArrayUtils.reverse(arr, 0, k - 1);
    ArrayUtils.reverse(arr, k, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  private void reverse(int[] arr) {
    ArrayUtils.reverse(arr, 0, arr.length - 1);
  }
}
