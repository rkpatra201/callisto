package org.dsa.examples.v1.sorting;

import org.dsa.examples.v1.sorting.BubbleSort;
import org.junit.Test;

import java.util.Arrays;

public class BubbleSortTest {

  @Test
  public void solution() {
    int[] arr = {5, 3, 4, 1, 2, 6};
    new BubbleSort().solution(arr);
    System.out.println(Arrays.toString(arr));
  }
}