package org.dsa.examples.v1.arrays;

import org.dsa.examples.v1.sorting.Merge2SortedArraysWithoutExtraSpace;
import org.junit.Test;

import java.util.Arrays;

public class Merge2SortedArraysWithoutExtraSpaceTest {

  @Test
  public void testSolution() {
    int[] arr1 = {7, 80};
    int[] arr2 = {1, 3, 5, 6, 8, 100};
    Merge2SortedArraysWithoutExtraSpace t1 = new Merge2SortedArraysWithoutExtraSpace();
    t1.solution(arr1, arr2);
    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));
  }
}