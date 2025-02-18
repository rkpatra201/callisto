package org.dsa.examples.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PartitionArraySmallAndLargeTest {

  @Test
  public void solution() {
    int[] arr = {65,64,10,9,12,11,15,13, 5,6};
    new PartitionArraySmallAndLarge().solution(arr, 9);
    System.out.println(Arrays.toString(arr));
  }
}