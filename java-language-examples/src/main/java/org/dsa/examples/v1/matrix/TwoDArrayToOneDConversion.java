package org.dsa.examples.v1.matrix;

public class TwoDArrayToOneDConversion {

  public int[] solution(int[][] arr, int i, int j) {
    int size = i * j;
    int[] result = new int[i * j];

    // row = index / j
    // col = index % j
    // always use j which is column size.

    for (int index = 0; index < size; index++) {
      int row = index / j;
      int col = index % j;
      result[index] = arr[row][col];
    }

    return result;
  }
}
