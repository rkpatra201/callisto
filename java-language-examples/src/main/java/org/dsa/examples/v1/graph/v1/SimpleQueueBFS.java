package org.dsa.examples.v1.graph.v1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SimpleQueueBFS {
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

        if (visited.containsKey(row + ":" + col)) {
          continue;
        }
        if (graph[row][col] == 0) {
          continue;

        }
        bfs(graph, row, col, rowMax, colMax);
      }
    }
  }

  private static Map<String, Boolean> visited = new HashMap<>();

  private static void bfs(int[][] graph, int row, int col, int rowMax, int colMax) {


    int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{row, col});

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] elem = queue.poll();
        row = elem[0];
        col = elem[1];

        System.out.println(graph[row][col]);

        String key = row + ":" + col;
        visited.put(key, true);

        for (int[] dir : directions) {
          int newRow = row + dir[0];
          int newCol = col + dir[1];

          boolean valid = newRow >= 0 && newRow < rowMax && newCol >= 0 && newCol < colMax && graph[newRow][newCol] != 0;
          if (!valid) {
            continue;
          }

          key = newRow + ":" + newCol;
          if (visited.containsKey(key)) {
            continue;
          }
          // due to above checks always valid positions by index and value being added to the queue
          queue.add(new int[]{newRow, newCol});
        }

      }
    }

  }
}
