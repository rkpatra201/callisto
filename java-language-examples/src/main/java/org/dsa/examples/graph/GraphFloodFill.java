package org.dsa.examples.graph;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/flood-fill/submissions/1585255649/
public class GraphFloodFill {

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int rowMax = image.length;
    int colMax = image[0].length;
    int original = image[sr][sc];
    traverse(image, sr, sc, rowMax, colMax, original, color);
    return image;
  }

  private Map<String, Boolean> visited = new HashMap<>();
  public void traverse(int[][] grid, int  row, int col, int rowMax, int colMax, int original, int color){

    boolean valid = 0 <= row && row < rowMax && 0 <= col && col < colMax;
    if(!valid){
      return;
    }

    int current = grid[row][col];
    if(current == color){
      return;
    }

    if(current != original){
      return;
    }
    String key = row +":"+col;
    if(visited.containsKey(key)){
      return;
    }

    visited.put(key, true);

    grid[row][col] = color;

    traverse(grid, row+1, col, rowMax, colMax, original, color);

    traverse(grid, row-1, col, rowMax, colMax, original, color);

    traverse(grid, row, col+1, rowMax, colMax, original, color);

    traverse(grid, row, col-1, rowMax, colMax, original, color);

  }

}
