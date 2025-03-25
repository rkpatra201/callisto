package org.dsa.examples.graph.v1;

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

        boolean valid = row >= 0 && row < rowMax && col >= 0 && col < colMax;
        if (!valid) {
          continue;
        }

        if (graph[row][col] == 0) {
          continue;
        }

        String key = row + ":" + col;
        if (visited.containsKey(key)) {
          continue;
        }

        System.out.println(graph[row][col]);

        visited.put(key, true);


        for (int[] dir : directions) {
          queue.add(new int[]{row + dir[0], col + dir[1]});
        }

      }
    }

  }
}
