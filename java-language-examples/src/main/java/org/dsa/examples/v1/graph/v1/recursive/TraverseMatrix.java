package org.dsa.examples.v1.graph.v1.recursive;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TraverseMatrix {
  public static void main(String[] args) {
    int[][] graph = {
        {1, 1, 0, 1, 1},
        {1, 1, 0, 1, 1},
        {1, 0, 0, 1, 1},
        {1, 0, 0, 1, 1},
    };

    traverseGraph(graph);
  }

  private static void traverseGraph(int[][] graph) {
    int rowMax = graph.length;
    int colMax = graph[0].length;
    for (int row = 0; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {
        dfs(graph, row, col, rowMax, colMax);
      }
    }
  }

  private static Set<String> visited = new HashSet<>();
  private static int[][] dirs = {
      {1, 0},
      {-1, 0},
      {0, 1},
      {0, -1}
  };

  private static void dfs(int[][] graph, int row, int col, int rowMax, int colMax) {
    String currKey = row + ":" + col;
    boolean isValid = row >= 0 && row < rowMax
        && col >= 0 && col < colMax
        && !visited.contains(currKey) // not visited
        && graph[row][col] == 1; // value  1

    if (!isValid) {
      return;
    }

    // add curr key as visited before exploring neighbours
    visited.add(currKey);
    System.out.println(graph[row][col]);

    // add all dirs to queue
    for (int[] dir : dirs) {
      int newRow = row + dir[0];
      int newCol = col + dir[1];
      dfs(graph, newRow, newCol, rowMax, colMax);
    }
  }
}

