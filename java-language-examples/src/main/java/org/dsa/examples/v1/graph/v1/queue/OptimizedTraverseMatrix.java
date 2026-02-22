package org.dsa.examples.v1.graph.v1.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OptimizedTraverseMatrix {
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
        bfs(graph, row, col, rowMax, colMax);
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

  private static void bfs(int[][] graph, int row, int col, int rowMax, int colMax) {
    String key = row + ":" + col;
    if (visited.contains(key) || graph[row][col] == 0) {
      return;
    }

    System.out.println("explore in bfs");
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{row, col});
    visited.add(row+":"+col);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {

        int[] curr = q.poll(); // poll
        System.out.println(graph[curr[0]][curr[1]]); // print

        // add all dirs to queue
        for (int[] dir : dirs) {
          int newRow = curr[0] + dir[0];
          int newCol = curr[1] + dir[1];

          String newKey = newRow + ":" + newCol;
          boolean isValid = newRow >= 0 && newRow < rowMax
              && newCol >= 0 && newCol < colMax
              && !visited.contains(newKey) // not visited
              && graph[newRow][newCol] == 1; // value  1

          if (!isValid) { // validate
            continue;
          }
          visited.add(newKey);
          q.add(new int[]{newRow, newCol}); // put in queue
        }
      }
    }

  }
}
