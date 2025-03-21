package org.dsa.examples.dp.grid;

import org.junit.Test;

import static org.junit.Assert.*;

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