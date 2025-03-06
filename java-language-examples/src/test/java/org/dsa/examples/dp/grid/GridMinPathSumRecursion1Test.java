package org.dsa.examples.dp.grid;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridMinPathSumRecursion1Test {

  @Test
  public void solution() {
    int[][] grid = {
        {1,3},
        {1,5}
    };
    int result = new GridMinPathSumRecursion1().solution(grid);
    System.out.println(result);
  }
}