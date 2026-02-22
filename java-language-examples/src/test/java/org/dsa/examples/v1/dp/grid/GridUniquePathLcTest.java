package org.dsa.examples.v1.dp.grid;

import org.dsa.examples.v1.dp.grid.Lc_GridUniquePath;
import org.junit.Test;

public class GridUniquePathLcTest {

  @Test
  public void solution() {
    int result = new Lc_GridUniquePath().solution(3,7);
    System.out.println(result);
  }
}