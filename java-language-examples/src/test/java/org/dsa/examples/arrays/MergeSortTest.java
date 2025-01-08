package org.dsa.examples.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortTest {

  @Test
  public void solution() {
    int[] arr = {10,3,2,8,6};
    MergeSort sort = new MergeSort();
    sort.solution(arr);
    System.out.println(Arrays.toString(arr));
  }
}