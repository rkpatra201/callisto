package org.dsa.examples.v1.dp.grid;

import org.dsa.examples.v1.dp.grid.GridPrintPathToDestination;
import org.junit.Test;

public class GridPrintPathToDestinationTest {

  @Test
  public void solution() {
    int[][] arr = {
        {1,1,1,0},
        {1,0,1,0},
        {1,0,1,0},
        {1,1,1,1},
    };
    new GridPrintPathToDestination().solution(arr, 0,0, 3,3);
  }
}