package org.dsa.examples.v1.graph.traversal;

import org.dsa.examples.v1.graph.traversal.CountClusterSize;
import org.junit.Test;


public class CountClusterSizeTest {

  @Test
  public void solution() {
    int[][] arr={
        {0,0,1,1,0},
        {0,0,1,1,0},
        {0,0,0,0,0},
        {0,0,1,1,1},
        {0,0,1,0,0},
    };
    new CountClusterSize().solution(arr, 0,2);
  }
}