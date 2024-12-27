package org.dsa.examples.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RemoveDuplicateFromSortedArrayTest {

  @Test
  public void solution() {
    int[] arr = {1, 1, 2, 2, 2, 3, 4, 5, 5, 6, 6, 6, 7};
    new RemoveDuplicateFromSortedArray().solution(arr);
    System.out.println(Arrays.toString(arr));
  }
}