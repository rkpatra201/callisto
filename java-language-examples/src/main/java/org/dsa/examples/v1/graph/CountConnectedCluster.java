package org.dsa.examples.v1.graph;

public class CountConnectedCluster {

  public int solution(int[][] arr, int row, int col) {
    int count = 0;
    int[][] visited = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (visited[i][j] == -1) {
          continue;
        }
        if (arr[i][j] == 0) {
          continue;
        }
        visit(arr, i, j, row, col, visited);
        count++;
      }
    }
    return count;
  }

  private void visit(int[][] arr, int i, int j, int row, int col, int[][] visit) {

    // check i,j should not go beyond row, col
    if (i >= row || j >= col || i < 0 || j < 0) {
      return;
    }
    // no need to start dfs traverse on an element which is 0
    if (arr[i][j] == 0) {
      return;
    }
    // skip visited element or indexes
    if (visit[i][j] == -1) {
      return;
    }
    visit[i][j] = -1; // mark current i,j as visited
    // move in all 4 directions
    visit(arr, i + 1, j, row, col, visit);
    visit(arr, i - 1, j, row, col, visit);
    visit(arr, i, j + 1, row, col, visit);
    visit(arr, i, j - 1, row, col, visit);
  }
}
