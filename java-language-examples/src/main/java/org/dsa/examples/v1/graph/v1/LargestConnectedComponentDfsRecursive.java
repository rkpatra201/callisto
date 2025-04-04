package org.dsa.examples.v1.graph.v1;

import java.util.HashSet;
import java.util.Set;

public class LargestConnectedComponentDfsRecursive {

  private static int[][] graph = {
      {1, 1, 1, 0, 0, 0, 0, 0},
      {1, 1, 1, 0, 1, 1, 1, 1},
      {1, 1, 1, 0, 1, 1, 1, 1},
      {0, 0, 0, 0, 1, 1, 1, 1},
      {0, 0, 0, 0, 1, 1, 1, 1},
  };

  public static void main(String[] args) {
    int rowMax = graph.length;
    int colMax = graph[0].length;
    int prevCount = 0;
    Set<String> visited = new HashSet<>();
    for (int row = 0; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {
        if(visited.contains(row+":"+col)){
          continue;
        }
        if (graph[row][col] == 0) {
          continue;
        }
      //  visited.clear();
        visited.add(row + ":" + col);
        dfs(row, col, rowMax, colMax, visited);
        int total = visited.size();
        System.out.println("component size: "+(total - prevCount));
        prevCount = total;
      }
    }
  }

  private static int[][] directions = {
      {1, 0},
      {-1, 0},
      {0, 1},
      {0, -1},
  };

  private static void dfs(int row, int col, int rowMax, int colMax, Set<String> visited) {

    for (int[] dir : directions) {
      int newRow = row + dir[0];
      int newCol = col + dir[1];

      boolean valid = newRow >= 0 && newRow < rowMax // row valid
          && newCol >= 0 && newCol < colMax // col valid
          && graph[newRow][newCol] != 0 // not zero
          && !visited.contains(newRow + ":" + newCol); // not visited

      if (!valid) {
        continue;
      }
      visited.add(newRow + ":" + newCol);
//      System.out.println(visited);
      dfs(newRow, newCol, rowMax, colMax, visited);
    }
  }


}
