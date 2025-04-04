package org.dsa.examples.v1.dp.grid;

import java.util.ArrayList;
import java.util.List;

/**
 * given a binary maze with  0 or 1 as value
 * print all path to ceil(m,n) from ceil(i,j)
 * should not jump on ceil with value 0.
 * allowed to traverse in all directions
 */
public class GridPrintPathToDestination {

  public void solution(int[][] arr, int i, int j, int m, int n) {
    List<String> path = new ArrayList<>();
    printPath(arr, i, j, m, n, path);
  }

  private void printPath(int[][] arr, int i, int j, int m, int n, List<String> path) {

    if (i > m || j > n || i < 0 || j < 0) {
      return;
    }

    if (arr[i][j] == 0) {
      return;
    }

    path.add(i + ":" + j + "=" + (arr[i][j]));

    if (i == m && j == n) {
      System.out.println(path);
      path.remove(path.size() - 1);
      return;
    }


    arr[i][j] = 0; // can be another array visited[i][j] = true

    printPath(arr, i + 1, j, m, n, path); // down
    printPath(arr, i, j + 1, m, n, path); // right
    printPath(arr, i - 1, j, m, n, path); // up
    printPath(arr, i, j - 1, m, n, path); // left

    path.remove(path.size() - 1);

    arr[i][j] = 1; // visited[i][j] = false
  }
}
