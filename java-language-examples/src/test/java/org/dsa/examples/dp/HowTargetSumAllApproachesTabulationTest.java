package org.dsa.examples.dp;

import org.dsa.examples.dp.sum.Shortest_HowTargetSum_Tabulation;
import org.junit.Test;

import java.util.Arrays;

public class HowTargetSumAllApproachesTabulationTest {

  @Test
  public void solution() {
    int target = 8;
    int[] inputs = {2, 3, 5};
    int[] result = new Shortest_HowTargetSum_Tabulation().solution(target, inputs);
    System.out.println(Arrays.toString(result));
  }
}