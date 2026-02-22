package org.dsa.examples.v1.arrays;

import org.dsa.examples.v1.arrays.PivotPartition;
import org.junit.Test;

import java.util.Arrays;


public class PivotPartitionTest {

  @Test
  public void solution() {
    int[] nums = {1,3,2,4,10,11,9,5};
    int[] copy = Arrays.copyOfRange(nums, 0, nums.length);
    PivotPartition partition = new PivotPartition();
    partition.solution(nums);
    partition.solution1(copy);
    System.out.println(Arrays.toString(nums));
    System.out.println(Arrays.toString(copy));
  }
}