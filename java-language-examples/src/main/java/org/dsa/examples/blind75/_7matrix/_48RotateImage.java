package org.dsa.examples.blind75._7matrix;

// https://leetcode.com/problems/rotate-image/submissions/1608212925/?envType=problem-list-v2&envId=oizxjoit
public class _48RotateImage {
  public void rotate(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    int size = row * col;
    transposeOfMatrix(matrix, row, col, size);
    swapEachColumnElements(matrix, row, col);
  }

  private static void swapEachColumnElements(int[][] arr, int row, int col) {
    int colElementStartIndex = 0;
    int colElementEndIndex = row - 1;

    int colPositionIndex = 0;
    while (colPositionIndex < col) {

      if (colElementStartIndex < colElementEndIndex) {
        // only for reference
        int start = arr[colPositionIndex][colElementStartIndex];
        int end = arr[colPositionIndex][colElementEndIndex];

        int temp = arr[colPositionIndex][colElementStartIndex];
        arr[colPositionIndex][colElementStartIndex] = arr[colPositionIndex][colElementEndIndex];
        arr[colPositionIndex][colElementEndIndex] = temp;

        colElementStartIndex++;
        colElementEndIndex--;
      } else {
        colPositionIndex++;
        colElementStartIndex = 0;
        colElementEndIndex = row - 1;
      }
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
