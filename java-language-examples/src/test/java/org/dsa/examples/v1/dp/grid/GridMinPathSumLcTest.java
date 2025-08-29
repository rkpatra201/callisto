package org.dsa.examples.v1.dp.grid;

import org.dsa.examples.v1.dp.grid.Lc_GridMinPathSum;
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