package org.dsa.examples.arrays;


import org.junit.Test;

import java.util.Arrays;

public class EqualSumSubArraysTest {

  @Test
  public void solution1() {
    int[] arr = {1, 2, 3, 3, 2, 1};
    int[][] result = EqualSumSubArrays.solution(arr);
    System.out.println(Arrays.deepToString(result));
  }

  @Test
  public void solution2() {
    int[] arr = {1, 2, 3, 4, 8, 2};
    int[][] result = EqualSumSubArrays.solution(arr);
    System.out.println(Arrays.deepToString(result));
  }

  @Test
  public void solution3() {
    int[] arr = {1, -2, 3, -3, 5};
    int[][] result = EqualSumSubArrays.solution(arr);
    System.out.println(Arrays.deepToString(result));
  }


  @Test
  public void solution4() {
    int[] arr = {1,2,4};
    int[][] result = EqualSumSubArrays.solution(arr);
    System.out.println(Arrays.deepToString(result));
  }


}