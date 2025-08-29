package org.dsa.examples.v1.graph.v1.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class OptimizedTraverseAL {
  public static void main(String[] args) {
    char[][] edges = {
        {'a', 'b'},
        {'a', 'c'},
        {'b', 'c'},
        {'b', 'e'},
        {'b', 'd'},
        {'c', 'e'}
    };
    bfs(buildGraph(edges), edges[0][0]);
  }

  private static void bfs(Map<Character, List<Character>> graph, Character start) {
    System.out.println(graph);
    Set<Character> visited = new HashSet<>();
    Stack<Character> stack = new Stack<>();
    stack.add(start);
    visited.add(start);
    while (!stack.isEmpty()) {
      int size = stack.size();
      for (int i = 0; i < size; i++) {
        Character curr = stack.pop();
        System.out.println(curr);
        List<Character> friends = graph.get(curr);
        if (friends != null) {
          for (Character f : friends) {
            if (!visited.contains(f)) {
              visited.add(f);
              stack.add(f);
            }
          }
        }
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
