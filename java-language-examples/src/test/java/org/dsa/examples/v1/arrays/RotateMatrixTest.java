package org.dsa.examples.v1.arrays;

import org.dsa.examples.v1.arrays.RotateMatrix;
import org.junit.Test;


public class RotateMatrixTest {

  @Test
  public void solution() {
    int[][] arr = {
        {1,2,3},
        {4,5,6},
        {7,8,9}
    };
//    System.out.println(Arrays.deepToString(arr));
    org.dsa.examples.v1.arrays.RotateMatrix m = new RotateMatrix();
    m.solution(arr, 9);
//    System.out.println(Arrays.deepToString(arr));
  }
}