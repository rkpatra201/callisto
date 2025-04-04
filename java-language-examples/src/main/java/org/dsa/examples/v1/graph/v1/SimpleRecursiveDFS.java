package org.dsa.examples.v1.graph.v1;

import java.util.HashMap;
import java.util.Map;

public class SimpleRecursiveDFS {
  public static void main(String[] args) {
    int[][] graph = {
        {10, 0, 20},
        {30, 0, 40},
        {50, 60, 0}
    };

    int rowMax = graph.length;
    int colMax = graph[0].length;

    for (int row = 0; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {
        dfs(graph, row, col, rowMax, colMax);
      }
    }
  }

  private static Map<String, Boolean> visited = new HashMap<>();

  private static void dfs(int[][] graph, int row, int col, int rowMax, int colMax) {
    // step1: validate index of row and col
    boolean valid = row >= 0 && row < rowMax && col >= 0 && col < colMax;
    if (!valid) {
      return;
    }

    // step2: check for invalid values like 0
    if (graph[row][col] == 0) {
      return;
    }

    // step3: check if already visited row,col
    String key = row + ":" + col;
    if (visited.containsKey(key)) {
      return;
    }

    // step4: visit
    System.out.println(graph[row][col]);

    // step5: mark as visited
    visited.put(key, true);

    // step6: recursive explore in all 4 directions
    dfs(graph, row + 1, col, rowMax, colMax);
    dfs(graph, row - 1, col, rowMax, colMax);
    dfs(graph, row, col + 1, rowMax, colMax);
    dfs(graph, row, col - 1, rowMax, colMax);
  }
}
