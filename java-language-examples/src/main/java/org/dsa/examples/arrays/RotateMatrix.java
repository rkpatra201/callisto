package org.dsa.examples.arrays;

import java.util.Arrays;

// rotate matrix by 90 degree
public class RotateMatrix {
  /**
   * 1,2,3
   * 5,6,7
   * 4,2,3
   * <p>
   * transpose:
   * <p>
   * 1 5 4
   * 2 6 2
   * 3 7 3
   *
   * swap each column:
   *
   * 3 7 3
   * 2 6 2
   * 1 5 4
   *
   * <p>
   * ans:
   * <p>
   * 3 7 3
   * 2 6 2
   * 1 5 4
   *
   * @param arr
   * @return
   */
  public void solution(int[][] arr, int elementCount) {
    int row = (int) Math.sqrt(elementCount);
    int col = (int) Math.sqrt(elementCount);
    int size = (int) Math.sqrt(elementCount);

    System.out.println(Arrays.deepToString(arr));

    transposeOfMatrix(arr, row, col, size);

    System.out.println(Arrays.deepToString(arr));

    swapEachColumnElements(arr, row, col);

    System.out.println(Arrays.deepToString(arr));

  }

  private static void swapEachColumnElements(int[][] arr, int row, int col) {
    int colElementStartIndex = 0;
    int colElementEndIndex = row - 1;

    int colPositionIndex = 0;
    while (colPositionIndex < col) {
      if (colElementStartIndex == colElementEndIndex) { // all elements swapped.
        // move to next column
        colPositionIndex++;
        colElementStartIndex = 0;
        colElementEndIndex = row - 1;
        continue;
      }

      // only for reference
      int start = arr[colPositionIndex][colElementStartIndex];
      int end = arr[colPositionIndex][colElementEndIndex];

      int temp = arr[colPositionIndex][colElementStartIndex];
      arr[colPositionIndex][colElementStartIndex] = arr[colPositionIndex][colElementEndIndex];
      arr[colPositionIndex][colElementEndIndex] = temp;

      colElementStartIndex++;
      colElementEndIndex--;
    }
  }

  private static void transposeOfMatrix(int[][] arr, int row, int col, int size) {
    int diagonalIndex = 0;
    while (diagonalIndex < size) {
      int colIndex = diagonalIndex;
      int rowIndex = diagonalIndex;
      while (colIndex < col && rowIndex < row) {

        // just for understanding these 2 variables declared
        int colElementValue = arr[diagonalIndex][colIndex];
        int rowElementValue = arr[rowIndex][diagonalIndex];

        int temp = arr[diagonalIndex][colIndex];
        arr[diagonalIndex][colIndex] = arr[rowIndex][diagonalIndex];
        arr[rowIndex][diagonalIndex] = temp;
        colIndex++;
        rowIndex++;
      }
      diagonalIndex++;
    }
  }
}
