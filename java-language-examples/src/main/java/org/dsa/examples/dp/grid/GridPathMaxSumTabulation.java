package org.dsa.examples.dp.grid;

public class GridPathMaxSumTabulation {

  private int[][] tab = null;

  // iterating the array from bottom so that,
  // the tab array can be initialized from the last

  public int solution(int[][] arr, int m, int n) {

    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (i == m - 1 && j == n - 1) {
          tab = new int[m][n];
          tab[i][j] = arr[i][j];
        } else {
          int down = i >= m - 1 ? 0 : tab[i + 1][j];
          int right = j >= n - 1 ? 0 : tab[i][j + 1];
          tab[i][j] = arr[i][j] + Math.max(down , right);
        }
      }
    }
    return tab[0][0];
  }


  public int solution1(int[][] arr, int m, int n) {

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          tab = new int[m][n];
          tab[i][j] = arr[i][j];
        } else {
          int down = i ==0 ? 0 : tab[i - 1][j];
          int right = j == 0 ? 0 : tab[i][j - 1];
          tab[i][j] = arr[i][j] + Math.max(down , right);
        }
      }
    }
    return tab[m-1][n-1];
  }
}
