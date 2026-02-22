package org.dsa.examples.v1.graph.v1.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TraverseAL {
  public static void main(String[] args) {
    char[][] edges = {
        {'a', 'b'},
        {'a', 'c'},
        {'b', 'c'},
        {'b', 'e'},
        {'b', 'd'},
        {'c', 'e'}
    };
    dfs(buildGraph(edges), edges[0][0]);
  }

  private static void dfs(Map<Character, List<Character>> graph, Character start) {
    System.out.println(graph);
    Set<Character> visited = new HashSet<>();
    Stack<Character> stack = new Stack<>();
    stack.add(start);

    while (!stack.isEmpty()) {
      Character curr = stack.pop();
      if (visited.contains(curr)) {
        continue;
      }
      visited.add(curr);
      System.out.println(curr);

      List<Character> friends = graph.get(curr);
      if (friends != null) {
        stack.addAll(friends);
      }
    }
  }

  private static Map<Character, List<Character>> buildGraph(char[][] edges) {
    Map<Character, List<Character>> graph = new HashMap<>();
    for (char[] edge : edges) {
      graph.computeIfAbsent(edge[0], k -> new ArrayList<>())
          .add(edge[1]);
      graph.computeIfAbsent(edge[1], k -> new ArrayList<>())
          .add(edge[0]);
    }
    return graph;
  }
}
