package org.dsa.examples.dp.grid;

import org.junit.Test;

public class GridMinPathSumLcTest {

  @Test
  public void solution() {
    int[][] grid = {
        {1,3},
        {1,5}
    };
    int result = new Lc_GridMinPathSum().solution(grid);
    System.out.println(result);
  }
}