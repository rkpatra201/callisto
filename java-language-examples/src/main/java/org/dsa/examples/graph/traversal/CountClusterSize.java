package org.dsa.examples.graph.traversal;

import java.util.HashSet;
import java.util.Set;

public class CountClusterSize {

  public int solution(int[][] datacenter, int row, int col) {

    Set<String> set = new HashSet<>();
    findSize(datacenter, row, col, set);

    System.out.println(set.size());

    return set.size();

  }


  public void findSize(int[][] datacenter, int row, int col, Set<String> locations) {
    try {
      if (datacenter[row][col] == 0) {
        return;
      }
    } catch (Exception e) {
      return;
    }
    if (!locations.add(row + "_" + col)) {
      return;
    }

    findSize(datacenter, row, col + 1, locations);
    findSize(datacenter, row, col - 1, locations);
    findSize(datacenter, row + 1, col, locations);
    findSize(datacenter, row - 1, col, locations);

  }
}
