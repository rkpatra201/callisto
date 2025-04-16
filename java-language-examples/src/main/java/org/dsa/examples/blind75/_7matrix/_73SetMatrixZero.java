package org.dsa.examples.blind75._7matrix;

// https://leetcode.com/problems/set-matrix-zeroes/submissions/1608466460/
public class _73SetMatrixZero {
  public void setZeroes(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    boolean hasFirstRowZero = false;
    boolean hasFirstColZero = false;
    int i = 0;
    int j = 0;
    while (j < col) {
      hasFirstRowZero = matrix[i][j] == 0;
      if (hasFirstRowZero) {
        break;
      }
      j++;
    }

    i = 0;
    j = 0;
    while (i < row) {
      hasFirstColZero = matrix[i][j] == 0;
      if (hasFirstColZero) {
        break;
      }
      i++;
    }

    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (firstRC(r, c)) {
          continue;
        }

        int v = matrix[r][c];
        if (v == 0) {
          matrix[r][0] = 0;
          matrix[0][c] = 0;
        }
      }
    }

    i = 1;
    j = 0;
    while (i < row) {
      if (matrix[i][j] == 0) {
        int tj = 0;
        while (tj < col) {
          matrix[i][tj] = 0;
          tj++;
        }
      }
      i++;
    }

    i = 0;
    j = 1;
    while (j < col) {
      if (matrix[i][j] == 0) {
        int tr = 0;
        while (tr < row) {
          matrix[tr][j] = 0;
          tr++;
        }
      }
      j++;
    }

    i = 0;
    j = 0;
    if (hasFirstRowZero) {
      while (j < col) {
        matrix[i][j] = 0;
        j++;
      }
    }

    i = 0;
    j = 0;
    if (hasFirstColZero) {
      while (i < row) {
        matrix[i][j] = 0;
        i++;
      }
    }
  }

  private boolean firstRC(int i, int j) {
    return i == 0 || j == 0;
  }
}
