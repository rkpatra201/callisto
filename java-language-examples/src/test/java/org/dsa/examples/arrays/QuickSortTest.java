package org.dsa.examples.arrays;

import org.dsa.examples.sorting.QuickSort;
import org.junit.Test;

import java.util.Arrays;


public class QuickSortTest {

  @Test
  public void solution() {
    int[] nums = {1,2,5,3,8,4,7,5};//{10, 2, 30, 6, 7, 4, 5};
    QuickSort sort = new QuickSort();
    sort.solution(nums);
    System.out.println(Arrays.toString(nums));
  }
}