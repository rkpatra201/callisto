package org.dsa.examples.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RotateMatrixTest {

  @Test
  public void solution() {
    int[][] arr = {
        {1,2,3},
        {4,5,6},
        {7,8,9}
    };
//    System.out.println(Arrays.deepToString(arr));
    RotateMatrix m = new RotateMatrix();
    m.solution(arr, 9);
//    System.out.println(Arrays.deepToString(arr));
  }
}