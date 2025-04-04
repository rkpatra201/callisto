package org.dsa.examples.v1.arrays;

import org.dsa.examples.v1.arrays.RemoveDuplicateFromSortedArray;
import org.junit.Test;

import java.util.Arrays;


public class RemoveDuplicateFromSortedArrayTest {

  @Test
  public void solution() {
    int[] arr = {1, 1, 2, 2, 2, 3, 4, 5, 5, 6, 6, 6, 7};
    new RemoveDuplicateFromSortedArray().solution(arr);
    System.out.println(Arrays.toString(arr));
  }
}