package org.dsa.examples.arrays;

import org.junit.Assert;
import org.junit.Test;

public class SelectionSortTest {

  @Test
  public void solution() {
    int[] arr = {10, 3, 2, 5, 1, 7, 8, 9, -1};
    SelectionSort selectionSort = new SelectionSort();
    selectionSort.solution(arr);
    int[] expectedValue = {-1, 1, 2, 3, 5, 7, 8, 9, 10};
    Assert.assertArrayEquals(expectedValue, arr);
  }
}