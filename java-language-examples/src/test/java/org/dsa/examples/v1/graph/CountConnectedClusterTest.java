package org.dsa.examples.v1.graph;

import org.dsa.examples.v1.graph.CountConnectedCluster;
import org.junit.Test;

public class CountConnectedClusterTest {

  @Test
  public void solution() {
    int[][] arr = {
        {0, 0, 1, 1},
        {0, 0, 1, 1},
        {0, 0, 0, 0},
        {0, 0, 1, 1},
        {0, 0, 1, 1},
        {1, 1, 0, 0},
        {0, 0, 0, 0},
        {1, 1, 0, 0},
    };
    int result =new CountConnectedCluster().solution(arr, 8, 4);
    System.out.println(result);
  }
}