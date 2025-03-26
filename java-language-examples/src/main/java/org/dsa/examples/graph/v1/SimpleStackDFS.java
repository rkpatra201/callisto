package org.dsa.examples.graph.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SimpleStackDFS {
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
        if(graph[row][col] == 0){
          continue;
        }
        if(visited.containsKey(row+":"+col)){
          continue;
        }
        dfs(graph, row, col, rowMax, colMax);
      }
    }
  }

  private static Map<String, Boolean> visited = new HashMap<>();

  private static void dfs(int[][] graph, int row, int col, int rowMax, int colMax) {

    int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    Stack<int[]> stack = new Stack<>();
    stack.push(new int[]{row, col});

    while (!stack.isEmpty()) {

      int[] elem = stack.pop();
      row = elem[0];
      col = elem[1];


      String key = row + ":" + col;

      System.out.println("result: "+graph[row][col]);

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
      //  System.out.println("push: "+graph[newRow][newCol]);
        stack.push(new int[]{newRow, newCol});
      }

    }

  }
}
