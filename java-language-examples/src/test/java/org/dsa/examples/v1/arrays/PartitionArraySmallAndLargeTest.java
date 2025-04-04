package org.dsa.examples.v1.arrays;

import org.dsa.examples.v1.arrays.PartitionArraySmallAndLarge;
import org.junit.Test;

import java.util.Arrays;

public class PartitionArraySmallAndLargeTest {

  @Test
  public void solution() {
    int[] arr = {65, 64, 10, 9, 12, 11, 15, 9, 13, 9, 5, 6, 9};
    new PartitionArraySmallAndLarge().solution(arr, 9);
    System.out.println(Arrays.toString(arr));
  }
}