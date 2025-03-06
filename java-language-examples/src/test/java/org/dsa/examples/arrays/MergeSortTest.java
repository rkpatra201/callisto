package org.dsa.examples.arrays;

import org.dsa.examples.sorting.MergeSort;
import org.junit.Test;

import java.util.Arrays;


public class MergeSortTest {

  @Test
  public void solution() {
    int[] arr = {10,3,2,8,6};
    MergeSort sort = new MergeSort();
    sort.solution(arr);
    System.out.println(Arrays.toString(arr));
  }
}