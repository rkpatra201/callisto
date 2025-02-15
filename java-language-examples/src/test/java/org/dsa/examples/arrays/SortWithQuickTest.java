package org.dsa.examples.arrays;

import org.junit.Test;

import java.util.Arrays;


public class SortWithQuickTest {

  @Test
  public void solution() {
    int[] nums = {1,2,3,8,4,7,5};//{10, 2, 30, 6, 7, 4, 5};
    SortWithQuick sort = new SortWithQuick();
    sort.solution(nums);
    System.out.println(Arrays.toString(nums));
  }
}