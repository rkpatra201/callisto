package org.dsa.examples.v1.graph.v1.recursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    Map<Character, List<Character>> graph = buildGraph(edges);
    System.out.println("DFS traversal starting from 'a':");
    dfs(graph, 'a');
  }

  // Public wrapper method to start the DFS
  public static void dfs(Map<Character, List<Character>> graph, Character start) {
      Set<Character> visited = new HashSet<>();
      dfsRecursive(graph, start, visited);
  }

  private static void dfsRecursive(Map<Character, List<Character>> graph, Character start, Set<Character> visited) {
    if (visited.contains(start)) {
      return;
    }
    visited.add(start);
    System.out.println(start);

    List<Character> neighbors = graph.get(start);
    if (neighbors != null) {
      for (Character neighbor : neighbors) {
        dfsRecursive(graph, neighbor, visited);
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