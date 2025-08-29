package org.dsa.examples.v1.graph.v1.topo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TopoDfs {
  public static void main(String[] args) {
    int[][] edges = {
        {1, 2},
        {1, 3},
        {1, 4},
        {2, 3},
        {2, 4},
        {3, 5}
    };
    dfs(buildGraph(edges), 1);
    displayTopo();
  }

  private static Stack<Integer> sortedStack = new Stack<>();
  private static Set<Integer> visited = new HashSet<>();

  private static void displayTopo() {
    while (!sortedStack.isEmpty()) {
      System.out.println(sortedStack.pop());
    }
  }

  private static void dfs(Map<Integer, List<Integer>> graph, int start) {
    if (visited.contains(start)) {
      return;
    }
    visited.add(start);
    List<Integer> friends = graph.get(start);
    if (friends != null) {
      for (Integer f : friends) {
        dfs(graph, f);
      }
    }
    sortedStack.add(start);
  }

  private static Map<Integer, List<Integer>> buildGraph(int[][] edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      int v1 = edge[0];
      int v2 = edge[1];
      graph.computeIfAbsent(v1, k -> new ArrayList<>())
          .add(v2);
      // graph is directed for topo sort
//      graph.computeIfAbsent(v2, k -> new ArrayList<>())
//          .add(v1);
    }
    return graph;
  }
}
