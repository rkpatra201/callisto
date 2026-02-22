package org.dsa.examples.v1.graph.v1.cycle;

import org.dsa.examples.v1.graph.Node;
import utils.GraphUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CycleInGraphMainBfs {

    public static void main(String[] args) {
        String[][] edges = {
                {"1", "2"},
                {"1", "3"},
                {"2", "4"},
                {"3", "5"},
                {"3", "6"},
                {"4", "8"},
                {"5", "8"},
                // another component below
                {"7", "9"},
                {"7", "10"},
                {"9", "11"},
                {"10", "11"},
        };

        GraphUtils.Graph graph = GraphUtils.createUndirectedPathGraph(edges);
        GraphUtils.displayAdjacencyList(graph);

        if (hasCycle(graph)) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does not contain a cycle.");
        }
    }

    public static boolean hasCycle(GraphUtils.Graph graph) {
        Set<String> visited = new HashSet<>();
        for (String nodeName : graph.getNodes()) {
            if (!visited.contains(nodeName)) {
                if (isCycleInComponent(graph, nodeName, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycleInComponent(GraphUtils.Graph graph, String startNodeName, Set<String> visited) {
        Queue<String> queue = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();

        queue.add(startNodeName);
        visited.add(startNodeName);
        parent.put(startNodeName, null);

        while (!queue.isEmpty()) {
            String currentNodeName = queue.poll();
            Node currentNode = graph.getNode(currentNodeName);

            for (Node neighbor : currentNode.getNeighbours()) {
                String neighborName = neighbor.getName();
                if (!visited.contains(neighborName)) {
                    visited.add(neighborName);
                    queue.add(neighborName);
                    parent.put(neighborName, currentNodeName);
                } else if (parent.get(currentNodeName) != null && !neighborName.equals(parent.get(currentNodeName))) {
                    // If the neighbor is visited and is not the parent, we have a cycle.
                    return true;
                }
            }
        }
        return false;
    }
}