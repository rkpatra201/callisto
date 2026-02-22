package org.dsa.examples.v1.matrix;

import org.dsa.examples.v1.matrix.TwoDArrayToOneDConversion;
import org.junit.Test;

import java.util.Arrays;

public class TwoDArrayToOneDConversionTest {

  @Test
  public void solution() {
    int[][] input = {
        {1,2,3,4},
        {4,5,6,7},
        {7,8,9,10},
    };
    int[] output = new TwoDArrayToOneDConversion().solution(input, 3, 4);
    System.out.println(Arrays.toString(output));
  }
}