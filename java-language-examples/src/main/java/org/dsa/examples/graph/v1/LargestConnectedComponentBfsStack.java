package org.dsa.examples.graph.v1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class LargestConnectedComponentBfsStack {

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
        if (visited.contains(row + ":" + col)) {
          continue;
        }
        if (graph[row][col] == 0) {
          continue;
        }
        //  visited.clear();
        visited.add(row + ":" + col);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        bfs(queue, rowMax, colMax, visited);
        int total = visited.size();
        System.out.println("component size: " + (total - prevCount));
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

  private static void bfs(Queue<int[]> queue, int rowMax, int colMax, Set<String> visited) {


    while (!queue.isEmpty()) {
      int[] elem = queue.poll();
      int row = elem[0];
      int col = elem[1];
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
        queue.add(new int[]{newRow, newCol});
      }
    }

  }

}
