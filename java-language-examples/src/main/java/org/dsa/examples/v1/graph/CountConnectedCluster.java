package org.dsa.examples.v1.graph;

public class CountConnectedCluster {

  public int solution(int[][] arr, int row, int col) {
    int count = 0;
    boolean[][] visited = new boolean[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (visited[i][j]) {
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

  private void visit(int[][] arr, int i, int j, int row, int col, boolean[][] visit) {

    // check i,j should not go beyond row, col
    if (i >= row || j >= col || i < 0 || j < 0) {
      return;
    }
    // no need to start dfs traverse on an element which is 0
    if (arr[i][j] == 0) {
      return;
    }
    // skip visited element or indexes
    if (visit[i][j]) {
      return;
    }

    visit[i][j] = true; // mark current i,j as visited
      int dir[][] = {
              {1, 0},
              {-1, 0},
              {0, 1},
              {0, -1}
      };

      for(int d[]: dir){
          int newRow = i + d[0];
          int newCol = j + d[1];
          visit(arr, newRow, newCol, row, col, visit);
      }
//    // move in all 4 directions
//    visit(arr, i + 1, j, row, col, visit);
//    visit(arr, i - 1, j, row, col, visit);
//    visit(arr, i, j + 1, row, col, visit);
//    visit(arr, i, j - 1, row, col, visit);
  }
}
