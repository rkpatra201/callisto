package org.dsa.examples.graph.traversal;

import org.junit.Test;

import static org.junit.Assert.*;

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