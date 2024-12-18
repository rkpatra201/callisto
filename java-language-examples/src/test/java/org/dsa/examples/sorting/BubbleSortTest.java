package org.dsa.examples.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BubbleSortTest {

  @Test
  public void solution() {
    int[] arr = {5, 3, 4, 1, 2, 6};
    new BubbleSort().solution(arr);
    System.out.println(Arrays.toString(arr));
  }
}