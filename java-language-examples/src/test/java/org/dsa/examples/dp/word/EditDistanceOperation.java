package org.dsa.examples.dp.word;

import org.junit.Test;

public class EditDistanceOperation {

  // https://www.enjoyalgorithms.com/blog/edit-distance
  // recursion
  @Test
  public void solutionRecursive() {
    String x = "cut";
    String y = "cat";
    int result = new EditDistance().solution(x, y);
    System.out.println(result);
  }

  @Test
  public void solutionIterative() {
    String x = "cu";
    String y = "cut";
    int result = new EditDistanceTabulation().solution(x, y);
    System.out.println(result);

  }
}