package org.dsa.examples.dp.grid;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridPathCountWaysRecursion1Test {

  @Test
  public void solution() {
    int result = new GridPathCountWaysRecursion1().solution(3,7);
    System.out.println(result);
  }
}