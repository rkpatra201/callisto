package org.dsa.examples.v1.graph.v1.stack;

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
    String key = row + ":" + col;
    if (visited.contains(key) || graph[row][col] == 0) {
      return;
    }

    System.out.println("explore in dfs");
    Stack<int[]> stack = new Stack<>();
    stack.add(new int[]{row, col});

    while (!stack.isEmpty()) {
      // pop and validate before exploring and adding other to queue
      int[] curr = stack.pop();
      String currKey = curr[0] + ":" + curr[1];
      boolean isValid = curr[0] >= 0 && curr[0] < rowMax
          && curr[1] >= 0 && curr[1] < colMax
          && !visited.contains(currKey) // not visited
          && graph[curr[0]][curr[1]] == 1; // value  1

      if (!isValid) {
        continue;
      }

      // add curr key as visited before exploring neighbours
      visited.add(currKey);
      System.out.println(graph[curr[0]][curr[1]]);

      // add all dirs to queue
      for (int[] dir : dirs) {
        int newRow = curr[0] + dir[0];
        int newCol = curr[1] + dir[1];
        stack.add(new int[]{newRow, newCol});
      }

    }

  }
}
