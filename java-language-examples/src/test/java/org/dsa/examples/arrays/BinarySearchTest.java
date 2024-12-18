package org.dsa.examples.arrays;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

  @Test
  public void solution() {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
    BinarySearch binarySearch = new BinarySearch();
    int index = binarySearch.solution(arr, 8);
    int actualValue = arr[index];
    int expectedValue = 8;
    Assert.assertEquals(expectedValue, actualValue);
    System.out.println(index);
  }
}