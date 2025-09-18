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
                {3, 5},
                // Add another component for testing
                {6, 7}
        };
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        Stack<Integer> sortedStack = topologicalSort(graph);

        System.out.println("Topological Sort:");
        while (!sortedStack.isEmpty()) {
            System.out.print(sortedStack.pop() + " ");
        }
        System.out.println();
    }

    public static Stack<Integer> topologicalSort(Map<Integer, List<Integer>> graph) {
        Stack<Integer> sortedStack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        // Handle all nodes to cater for disconnected graphs
        for (Integer node : graph.keySet()) {
            if (!visited.contains(node)) {
                dfs(graph, node, visited, sortedStack);
            }
        }
        return sortedStack;
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int start, Set<Integer> visited, Stack<Integer> sortedStack) {
        visited.add(start);
        List<Integer> neighbors = graph.get(start);
        if (neighbors != null) {
            for (Integer neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    dfs(graph, neighbor, visited, sortedStack);
                }
            }
        }
        sortedStack.push(start);
    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            graph.computeIfAbsent(v1, k -> new ArrayList<>()).add(v2);
            // Ensure all nodes are in the graph, even if they don't have outgoing edges
            graph.computeIfAbsent(v2, k -> new ArrayList<>());
        }
        return graph;
    }
}